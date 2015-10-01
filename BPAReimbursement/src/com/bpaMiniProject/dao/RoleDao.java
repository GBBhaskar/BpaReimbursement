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



import com.bpaMiniProject.model.ProjectMaster;
import com.bpaMiniProject.model.Role;

@Repository("RoleDao")
public class RoleDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger= LoggerFactory.getLogger(RoleDao.class);
	
	private Criteria createRoleCriteria(Session session,Role role,String matchType)
	{
		Criteria criteria=session.createCriteria(Role.class);
		
		if(role.getRoleId()!=null)
		{
			criteria.add(Restrictions.eq("roleId",role.getRoleId()));
		}
		if(role.getRoleName()!=null)
		{
			criteria.add(Restrictions.eq("roleName",role.getRoleName()));
		}
		if(role.getRoleDescription()!=null)
		{
			criteria.add(Restrictions.eq("roleDescription", role.getRoleDescription()));
		}
		
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	
	public int getRoleFilterCount(Role role)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createRoleCriteria(session,role,"");
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
	
	public List getRoleList(int startLimit,int endLimit,Role role,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createRoleCriteria(session,role,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("roleId"));

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
	
	public List getAllRoleList(Role role,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createRoleCriteria(session,role,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("roleId"));

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
	
	public void saveRole(Role role)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(role);                   
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
	
	public void removeRole(Integer roleId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	Role removeRole = (Role) session.load(Role.class, roleId);
            session.delete(removeRole);
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
	
	
	public Role getRoleById(Integer roleId)
	{
		logger.info("RoleId := " + roleId);
		Role role=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 role = (Role) session.get(Role.class,roleId);
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
	         return role;
	     }

	
}
