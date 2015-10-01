package com.bpaMiniProject.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bpaMiniProject.model.AutomobileExpense;
import com.bpaMiniProject.model.Department;
import com.bpaMiniProject.model.ProjectMaster;

@Repository("ProjectMasterDao")
public class ProjectMasterDao
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(ProjectMasterDao.class);
	
	private Criteria createProjectMasterCriteria(Session session,ProjectMaster projectMaster,String matchType)
	{
		Criteria criteria=session.createCriteria(ProjectMaster.class);
		
		if(projectMaster.getProjectMasterId()!=null)
		{
			criteria.add(Restrictions.eq("projectMasterId",projectMaster.getProjectMasterId()));
		}
		if(projectMaster.getProjectName()!=null)
		{
			criteria.add(Restrictions.eq("projectName",projectMaster.getProjectName()));
		}
		if(projectMaster.getProjectDescription()!=null)
		{
			criteria.add(Restrictions.eq("projectDescription",projectMaster.getProjectDescription()));
		}
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	public int getProjectMasterFilterCount(ProjectMaster projectMaster)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createProjectMasterCriteria(session,projectMaster,"");
        criteria.setProjection(Projections.rowCount());
		rowlist = criteria.list();	
		try 
	    {    	
			if (!rowlist.isEmpty()) 
			{ 
				resultTotal = (Integer) rowlist.get(0);
			}
	    }
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return resultTotal.intValue();    	
	}

	public List getProjectMasterList(int startLimit,int endLimit,ProjectMaster projectMaster,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createProjectMasterCriteria(session,projectMaster,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("projectMasterId"));

    		}
    		criteria.setFirstResult(startLimit);
            criteria.setMaxResults(endLimit);
            list = criteria.list();
            
         } 
         catch (HibernateException e)
         {
           e.printStackTrace();       
         }
         finally
         {
         	session.close();
         }
         return list;    		
    }
	
	public List getAllProjectManagerList(ProjectMaster projectMaster,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createProjectMasterCriteria(session,projectMaster,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("projectMasterId"));

    		}
    		
    		list = criteria.list();
            
         } 
         catch (HibernateException e)
         {
           e.printStackTrace();       
         }
         finally
         {
         	session.close();
         }
         return list;    		
    }
	
	public void saveProjectMaster(ProjectMaster projectMaster)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(projectMaster);                   
			session.flush();
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				session.close();
				session = null;
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void removeProjectMaster(Integer projectMasterId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	ProjectMaster project = (ProjectMaster) session.load(ProjectMaster.class, projectMasterId);
        	System.out.println("Inside the projectMasterDao"+project.getProjectMasterId());
        	project.setIsActive(false);
        	session.saveOrUpdate(project);
            session.flush();
        }
        catch (HibernateException e) 
        {
        	e.printStackTrace();
        }
        finally 
        {
        	try 
        	{
        		session.close();
        		session = null;
        	}
        	catch (Exception ex) 
        	{
        		ex.printStackTrace();
        	}
        }
	}
	
	public ProjectMaster getProjectMasterById(Integer projectMasterId)
	{
		logger.info("ProjectMasterId := " + projectMasterId);
		ProjectMaster project=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 project = (ProjectMaster) session.get(ProjectMaster.class,projectMasterId);
	        }
	        catch (HibernateException e) 
	        {
	        	e.printStackTrace();
	        }
	        finally 
	        {
	        	try
	        	{
	        		session.close();
	        		session = null;
	        	}
	        	catch (Exception ex) 
	        	{
	        		ex.printStackTrace();           
	        	}
	         }
	         return project;
	     }


}
