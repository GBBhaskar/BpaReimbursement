package com.bpaMiniProject.dao;
 
import java.util.ArrayList;
import java.util.List;
 


import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
 


import com.bpaMiniProject.model.Reimbursement;
 
@Repository("ReimbursementDao")
public class ReimbursementDao
{
	@Autowired
    private SessionFactory sessionFactory;
               
    private static final Logger logger = LoggerFactory.getLogger(ReimbursementDao.class);
               
    private Criteria createReimbursementCriteria(Session session,Reimbursement reim, String matchType) 
    {
    	Criteria criteria = session.createCriteria(Reimbursement.class);
    	
    	if (reim.getReimbursementCode() != null)
        {
    		if (matchType.equalsIgnoreCase("exact"))
            {
    			criteria.add(Restrictions.eq("reimbursementCode", reim.getReimbursementCode()).ignoreCase());
            }
            else
            {
            	criteria.add(Restrictions.like("reimbursementCode","%" + reim.getReimbursementCode() + "%").ignoreCase());
            }
        }
    	if (reim.getCreatedBy() != null)
    	{
    		criteria.add(Restrictions.eq("createdBy", reim.getCreatedBy()));
    	}
    	if (reim.getEmployeeName() != null)
    	{
    		criteria.add(Restrictions.eq("employeeName", reim.getEmployeeName()).ignoreCase());
    	}
    	if (reim.getStatus() != null)
    	{
    		criteria.add(Restrictions.eq("status", reim.getStatus()).ignoreCase());
    	}
    	if (reim.getManager() != null)
    	{
    		criteria.add(Restrictions.eq("manager", reim.getManager()));
    	}
    	if (reim.getReimbursementId() != null)
    	{
    		criteria.add(Restrictions.eq("reimbursementId", reim.getReimbursementId()));
    	}
    	return criteria;
    }
               
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public int getReimbursementFilterCount(Reimbursement reim)
    {
    	Session session = sessionFactory.openSession();
        Integer resultTotal = null;
        List rowlist = null;
        try
        {
        	Criteria criteria = createReimbursementCriteria(session, reim,"");
        	 /* the following code will fetch all the child records along with parent record.*/
            criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
            criteria.setFetchMode("autoMobileExpenses", FetchMode.SELECT);
            criteria.setFetchMode("entertainmentExpenses", FetchMode.SELECT);
            criteria.setFetchMode("miscellaneousExpenses", FetchMode.SELECT);
            criteria.setFetchMode("outStationExpenses", FetchMode.SELECT);
            criteria.setProjection(Projections.rowCount());
            rowlist = criteria.list();
            if (!rowlist.isEmpty())
            {
            	resultTotal = (Integer) rowlist.get(0);
                logger.info("Total Count := " + resultTotal.intValue());
            }
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
        return resultTotal.intValue();
    }
    
    public List getReimbursementList(int startLimit,int endLimit,Reimbursement reim,String search_1st_order_by)
    {
    	Session session = sessionFactory.openSession();
        List list = new ArrayList();
        try
        {
        	Criteria criteria = createReimbursementCriteria(session, reim,"");
            if (StringUtils.isNotBlank(search_1st_order_by)) 
            {
            	criteria.addOrder(Order.desc(search_1st_order_by).ignoreCase());
            }
            if (StringUtils.isBlank(search_1st_order_by)) 
            {
            	criteria.addOrder(Order.desc("reimbursementId"));
            }
            criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
            criteria.setFetchMode("autoMobilelExpenses", FetchMode.SELECT);
            criteria.setFetchMode("entertainmentExpenses", FetchMode.SELECT);
            criteria.setFetchMode("miscellaneousExpenses", FetchMode.SELECT);
            criteria.setFetchMode("outStationExpenses", FetchMode.SELECT);
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
         return list;
    }
    
    public void saveReimbursement(Reimbursement reim)
    {
    	Session session = sessionFactory.openSession();
        try
        {
        	session.saveOrUpdate(reim);                   
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
    
    public void deleteReimbursement(Integer reimbursementId)
    {
    	Session session = sessionFactory.openSession();
        try
        {
        	Reimbursement reimbursement = (Reimbursement) session.load(Reimbursement.class, reimbursementId);
            session.delete(reimbursement);
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
               
    public Reimbursement getReimbursementId(Integer reimbursementId)
    {
    	logger.info("ReimbursementId := " + reimbursementId);
        Session session = sessionFactory.openSession();
 
        Reimbursement reimbursement = null;
        try 
        {
        	reimbursement = (Reimbursement) session.get(Reimbursement.class,reimbursementId);
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
         return reimbursement;
     }
               
     public Reimbursement getUniqueReimbursement(Reimbursement reim)
     {
    	 Session session = sessionFactory.openSession();
         Reimbursement reimbursementObj = null;
                               
         try
         {
        	 Criteria criteria = createReimbursementCriteria(session, reim,"exact");
             criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
             /*criteria.setFetchMode("autoMobileExpenses", FetchMode.SELECT);
             criteria.setFetchMode("entertainmentExpenses", FetchMode.SELECT);
             criteria.setFetchMode("miscellaneousExpenses", FetchMode.SELECT);
             criteria.setFetchMode("outStationExpenses", FetchMode.SELECT);*/
             List list = criteria.list();
             if (criteria.list().size() != 0) 
             {
            	 reimbursementObj = (Reimbursement)criteria.list().get(0);
             }
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
         return reimbursementObj;
     }              
}



