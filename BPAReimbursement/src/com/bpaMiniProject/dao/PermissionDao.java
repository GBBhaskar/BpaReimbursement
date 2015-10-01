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
import com.bpaMiniProject.model.Permission;

@Repository("PermissionDao")
public class PermissionDao 
{
	@Autowired
	private SessionFactory  sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(PermissionDao.class);
	
	private Criteria createPermissionCriteria(Session session,Permission permission,String matchType)
	{
		Criteria criteria=session.createCriteria(Permission.class);
		
		if(permission.getPermissionId()!=null)
		{
			criteria.add(Restrictions.eq("permissionId",permission.getPermissionId()));
		}
		if(permission.getPermisssionName()!=null)
		{
			criteria.add(Restrictions.eq("permisssionName",permission.getPermisssionName()));
		}
		if(permission.getPermissionDescription()!=null)
		{
			criteria.add(Restrictions.eq("permissionDescription", permission.getPermissionDescription()));
		}
		
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	/*
	 * private Criteria createDepartmentCriteria(Session session,Department department,String matchType)
	{
		Criteria criteria=session.createCriteria(AutomobileExpense.class);
		
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
*/
	
	public int getPermissionFilterCount(Permission permission)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createPermissionCriteria(session,permission,"");
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
	
	public List getPermissionList(int startLimit,int endLimit,Permission permission,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createPermissionCriteria(session,permission,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("permissionId"));

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
	
	public List getAllPermissionList(Permission permission,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createPermissionCriteria(session,permission,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("permissionId"));

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
	

	public void savePermission(Permission permission)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(permission);                   
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
	
	public void removePermission(Integer permissionId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	Permission removePermission = (Permission) session.load(Permission.class, permissionId);
            session.delete(removePermission);
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
	
	public Permission getPermissionById(Integer permissionId)
	{
		logger.info("PermissionId := " + permissionId);
		Permission permission=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 permission = (Permission) session.get(Permission.class,permissionId);
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
	         return permission;
	     }

	
}
