package com.bpaMiniProject.dao;

import java.util.ArrayList;
import java.util.List;










import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bpaMiniProject.model.AutomobileExpense;
import com.bpaMiniProject.model.EntertainmentExpense;

@Repository("EntertainmentExpenseDao")
public class EntertainmentExpenseDao
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(EntertainmentExpenseDao.class);
	
	private Criteria createEntertainmentCriteria(Session session,EntertainmentExpense entertainment,String matchType)
	{
		Criteria criteria=session.createCriteria(EntertainmentExpense.class);
		
		if(entertainment.getReimbursement2()!=null)
		{
			criteria.add(Restrictions.eq("reimbursement2",entertainment.getReimbursement2()));
		}
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	public int getentertainmentFilterCount(EntertainmentExpense entertainment)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createEntertainmentCriteria(session,entertainment,"");
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
	
	public List getEntertainmentList(int startLimit,int endLimit,EntertainmentExpense entertainment,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createEntertainmentCriteria(session,entertainment,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("entertainmentExpenseId"));

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
	
	public List getAllEntertainmentListByReimbursement(EntertainmentExpense entertainment,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createEntertainmentCriteria(session,entertainment,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("entertainmentExpenseId"));

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

	public void saveEntertainment(EntertainmentExpense entertainment)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(entertainment);                   
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
	
	public void removeEntertainment(Integer entertainmentExpenseId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	EntertainmentExpense entertainment = (EntertainmentExpense) session.load(EntertainmentExpense.class, entertainmentExpenseId);
            session.delete(entertainment);
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
	
	public EntertainmentExpense getEntertainmentById(Integer entertainmentExpenseId)
	{
		logger.info("EntertainmentId := " + entertainmentExpenseId);
		EntertainmentExpense entertainment=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 entertainment = (EntertainmentExpense) session.get(EntertainmentExpense.class,entertainmentExpenseId);
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
	         return entertainment;
	     }
	
}
