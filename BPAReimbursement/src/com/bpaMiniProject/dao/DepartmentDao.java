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


@Repository("DepartmentDao")
public class DepartmentDao 
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDao.class);
	
	private Criteria createDepartmentCriteria(Session session,Department department,String matchType)
	{
		Criteria criteria=session.createCriteria(Department.class);
		
		if(department.getDepartmentId()!=null)
		{
			criteria.add(Restrictions.eq("departmentId",department.getDepartmentId()));
		}
		if(department.getDepartmentName()!=null)
			
		{
			criteria.add(Restrictions.eq("departmentName",department.getDepartmentName()));
		}
		if(department.getDepartmentDescription()!=null)
		{
			criteria.add(Restrictions.eq("departmentDescription",department.getDepartmentDescription()));
		}
		
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	
	public int getDeparmentFilterCount(Department department)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = new Integer(0);
        List rowlist = null;
		Criteria criteria = createDepartmentCriteria(session,department,"");
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
	
	public List getDepartmentList(int startLimit,int endLimit,Department department,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createDepartmentCriteria(session,department,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("departmentId"));

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
	
	
	public List getAllDepartmentList(Department department,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createDepartmentCriteria(session,department,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("departmentId"));

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
	
	
	
	public void saveDepartment(Department department)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(department);                   
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
	
	
	public void removeDepartment(Integer departmentId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	Department dept = (Department) session.load(Department.class, departmentId);
            session.delete(dept);
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
	
	
	
	public Department getDepartmentById(Integer departmentId)
	{
		logger.info("DepartmentId := " + departmentId);
		Department dept=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 dept = (Department) session.get(Department.class,departmentId);
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
	         return dept;
	     }
	
	
}
