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


@Repository("AutoMobileExpenseDao")
public class AutoMobileExpenseDao
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(AutoMobileExpenseDao.class);
	
	private Criteria createAutoMobileCriteria(Session session,AutomobileExpense autoMobile,String matchType)
	{
		Criteria criteria=session.createCriteria(AutomobileExpense.class);
		
		if(autoMobile.getReimbursement1()!=null)
		{
			criteria.add(Restrictions.eq("reimbursement1",autoMobile.getReimbursement1()));
		}
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	public int getAuoMobileFilterCount(AutomobileExpense autoMobile)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createAutoMobileCriteria(session,autoMobile,"");
        criteria.setProjection(Projections.rowCount());
		rowlist = criteria.list();	
		System.out.println("hai in mouni");
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
	
	public List getAutoMobileList(int startLimit,int endLimit,AutomobileExpense autoMobile,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createAutoMobileCriteria(session,autoMobile,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("automobileExpenseId"));

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
	
	public List getAllAutoMobileListByReimbursement(AutomobileExpense autoMobile,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createAutoMobileCriteria(session,autoMobile,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("automobileExpenseId"));

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
	
	public void saveAutoMobile(AutomobileExpense autoMobile)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(autoMobile);                   
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
	
	public void removeAutoMobile(Integer automobileExpenseId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	AutomobileExpense autoMobile = (AutomobileExpense) session.load(AutomobileExpense.class, automobileExpenseId);
            session.delete(autoMobile);
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

	public AutomobileExpense getAutoMobileById(Integer automobileExpenseId)
	{
		logger.info("AutoMobileId := " + automobileExpenseId);
		AutomobileExpense autoMobile=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 autoMobile = (AutomobileExpense) session.get(AutomobileExpense.class,automobileExpenseId);
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
	         return autoMobile;
	     }
	
}
