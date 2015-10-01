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

import com.bpaMiniProject.model.MiscellaneousExpense;

@Repository("MiscellaneousExpenseDao")
public class MiscellaneousExpenseDao
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(MiscellaneousExpenseDao.class);
	
	private Criteria createMiscellaneousCriteria(Session session,MiscellaneousExpense miscellaneous,String matchType)
	{
		Criteria criteria=session.createCriteria(MiscellaneousExpense.class);
		
		if(miscellaneous.getReimbursement3()!=null)
		{
			criteria.add(Restrictions.eq("reimbursement3",miscellaneous.getReimbursement3()));
		}
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	public int getMiscellaneousFilterCount(MiscellaneousExpense miscellaneous)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createMiscellaneousCriteria(session,miscellaneous,"");
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

	public List getMiscellaneousList(int startLimit,int endLimit,MiscellaneousExpense miscellaneous,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createMiscellaneousCriteria(session,miscellaneous,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("miscellaneousExpenseId"));

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
	public List getAllMiscellaneousListByReimbursement(MiscellaneousExpense miscellaneous,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createMiscellaneousCriteria(session,miscellaneous,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("miscellaneousExpenseId"));

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

		public void saveMiscellaneous(MiscellaneousExpense miscellaneous)
		{

			Session session = sessionFactory.openSession();
			try
			{
				session.saveOrUpdate(miscellaneous);                   
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
    
		public void removeMiscellaneous(Integer miscellaneousExpenseId)
		{
			Session session = sessionFactory.openSession();
	        try
	        {
	        	MiscellaneousExpense miscellaneous = (MiscellaneousExpense) session.load(MiscellaneousExpense.class, miscellaneousExpenseId);
	            session.delete(miscellaneous);
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

		public MiscellaneousExpense getMiscellaneousById(Integer miscellaneousExpenseId)
		{
			logger.info("MiscellaneousId := " + miscellaneousExpenseId);
			MiscellaneousExpense miscellaneous=null;
			Session session = sessionFactory.openSession();
			 try 
		        {
				 miscellaneous = (MiscellaneousExpense) session.get(MiscellaneousExpense.class,miscellaneousExpenseId);
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
		         return miscellaneous;
		     }
}