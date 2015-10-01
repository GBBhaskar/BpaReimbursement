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

import com.bpaMiniProject.model.EntertainmentExpense;
import com.bpaMiniProject.model.OutStationExpense;

@Repository("OutStationExpenseDao")
public class OutStationExpenseDao 
{
	@Autowired
    private SessionFactory sessionFactory;
    
	private static final Logger logger = LoggerFactory.getLogger(OutStationExpenseDao.class);
	
	private Criteria createOutStationCriteria(Session session,OutStationExpense outStation,String matchType)
	{
		Criteria criteria=session.createCriteria(OutStationExpense.class);
		
		if(outStation.getReimbursement4()!=null)
		{
			criteria.add(Restrictions.eq("reimbursement4",outStation.getReimbursement4()));
		}
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	public int getOutStationFilterCount(OutStationExpense outStation)
	{
		Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
		Criteria criteria = createOutStationCriteria(session,outStation,"");
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
	
	public List getOutStationList(int startLimit,int endLimit,OutStationExpense outStation,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createOutStationCriteria(session,outStation,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("outStationExpenseId"));

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
	
	public List getAllOutStationListByReimbursement(OutStationExpense outStation,String search_1st_order_by)
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList();
		
		 try
         {
			Criteria criteria=createOutStationCriteria(session,outStation,"");
         	if (StringUtils.isNotBlank(search_1st_order_by))
    		{
         		criteria.addOrder(Order.desc(search_1st_order_by));
    		}

    		if (StringUtils.isBlank(search_1st_order_by))
    		{
    			criteria.addOrder(Order.desc("outStationExpenseId"));

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
	
	public void saveOutStation(OutStationExpense outStation)
	{

		Session session = sessionFactory.openSession();
		try
		{
			session.saveOrUpdate(outStation);                   
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
	
	public void removeOutStation(Integer outStationExpenseId)
	{
		Session session = sessionFactory.openSession();
        try
        {
        	OutStationExpense outStation = (OutStationExpense) session.load(OutStationExpense.class, outStationExpenseId);
            session.delete(outStation);
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
	
	public OutStationExpense getOutStationById(Integer outStationExpenseId)
	{
		logger.info("OutStationId := " + outStationExpenseId);
		OutStationExpense outStation=null;
		 Session session = sessionFactory.openSession();
		 try 
	        {
			 outStation = (OutStationExpense) session.get(OutStationExpense.class,outStationExpenseId);
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
	       return outStation;
	  }

}
