package com.bpaMiniProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.bpaMiniProject.util.DatabaseLayerExceptions;



public class GenericDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
		/* saveOrUpdate Method */
	
	 protected void saveOrUpdate(Object objOfAnyClass) 
	 {
	    	Session session = sessionFactory.openSession();
	    	try
	    	{
	    		session.saveOrUpdate(objOfAnyClass);
	            session.flush();
	        }
	    	catch (HibernateException e) 
	    	{
	            handleException(e);
	        } 
	    	finally 
	    	{
	        	session.close();
	        }
	    }
	 
	 /* delete Method */
	 
	 protected void delete(Object objOfAnyClass)
	 {
	    	Session session = sessionFactory.openSession();
	    	try 
	    	{
	        	
	            session.delete(objOfAnyClass);
	            session.flush();
	        } 
	    	catch (HibernateException e)
	    	{
	            handleException(e);
	        } 
	    	finally 
	    	{
	        	session.close();
	        }
	    }
	 
	 /* find method-which accepts only integer based on dat we are going to find that only particular id related row/rows */
	 
	    protected Object find(Class clazz, Integer id) 
	    {
	        Object obj = null;
	        Session session = sessionFactory.openSession();
	        try
	        {
	        	obj = session.get(clazz, id);
	           
	        }
	        catch (HibernateException e)
	        {
	            handleException(e);
	        } 
	        finally
	        {
	        	session.close();
	        }
	        return obj;
	    }
	    
	    
	    /* findAll method-used to get the entire rows of that particular given class */
	    
	    protected List findAll(Class clazz)
	    {
	        List objects = null;
	        Session session = sessionFactory.openSession();
	        try 
	        {
	        	
	            Query query = session.createQuery("from " + clazz.getName());
	            objects = query.list();
	          
	        } 
	        catch (HibernateException e) 
	        {
	            handleException(e);
	        } 
	        finally 
	        {
	        	session.close();
	        }
	        return objects;
	    }
	    
	    
	    
	    protected int getObjectListCount(Class clazz,DetachedCriteria detachedCriteria)
	    {
	    	Integer resultTotal = null;
			List rowlist = null;
			 Session session = sessionFactory.openSession();  
	         try 
	         {
	        	
	             Criteria criteria = detachedCriteria.getExecutableCriteria(session);
	             criteria.setProjection(Projections.rowCount());
				 rowlist = criteria.list();			
				 if (!rowlist.isEmpty()) 
				 { 
					 resultTotal = (Integer) rowlist.get(0);
					//resultTotal = new Integer(resultTotalValue.intValue());
					//logger.info("Total records: " + resultTotal); 
				 }
	            
	         }
	         catch (HibernateException e)
	         {
	             handleException(e);
	         }
	         finally 
	         {
	         	session.close();
	         }
	         return resultTotal.intValue();    	
	    	
	    }
	    
	    
	    protected List getObjectListByRange(Class clazz,DetachedCriteria detachedCriteria,int start,int limit)
	    {
	    	 List list = null;
	    	 Session session = sessionFactory.openSession();
	         try
	         {
	            
	        	 Criteria criteria = detachedCriteria.getExecutableCriteria(session);
	        	 criteria.setFirstResult(start);
	             criteria.setMaxResults(limit);
	             if (criteria.list().size() != 0)
		       	 {
	            	 list=criteria.list();
		       	 }
	            
	            
	         } 
	         catch (HibernateException e)
	         {
	             handleException(e);
	         }
	         finally
	         {
	         	session.close();
	         }
	         return list;    	
	    	
	    }
	    
	    protected List getAllObjectList(Class clazz,DetachedCriteria detachedCriteria)
	    {
	    	 List list = null;
	    	 Session session = sessionFactory.openSession();
	         try
	         {
	            
	        	 Criteria criteria = detachedCriteria.getExecutableCriteria(session);
	        	 if (criteria.list().size() != 0)
	        	 {
	        		 list =  criteria.list();
	        	 }   
	         } 
	         catch (HibernateException e)
	         {
	             handleException(e);
	         }
	         finally 
	          {
	         	session.close();
	         }
	         return list;    	
	    	
	    }
	    protected Object getUniqueObject(Class clazz,DetachedCriteria objectCriteria) {
	        Object obj = null;
	       
	        
	   	 	Session session = sessionFactory.openSession();
	        try {
	           
	       	 Criteria crit = objectCriteria.getExecutableCriteria(session);
	       	 List list =  crit.list();
	       	 if (crit.list().size() != 0)
	       	 {
	       		 obj = list.get(0);
	       	 }
	       	 
	        } catch (HibernateException e) {
	            handleException(e);
	        } finally {
	        	session.close();
	        }       
	        
	        return obj;
	    }
	  protected void handleException(HibernateException e) throws DatabaseLayerExceptions 
	  {
	    	 
	        throw new DatabaseLayerExceptions(e);
	  }
}
/*-----------------------------------------------------------------------------------------------------------------*/
/*			REIMBURSEMENT DAO

package com.bpaMiniProject.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bpaMiniProject.model.EntertainmentExpense;
import com.bpaMiniProject.model.Reimbursement;

@Repository("ReimbursementDao")
public class ReimbursementDao extends GenericDao
{

	public ReimbursementDao() 
	{
		super();
	}
	
	private DetachedCriteria createReimbursementCriteria(Reimbursement reim,String matchType)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Reimbursement.class);
		
		if(reim.getReimbursementCode()!=null)
		{
			//detachedCriteria.add(Restrictions.eq("reimbursement",reim.getReimbursementCode()));
			detachedCriteria.add(Restrictions.eq("reimbursementCode",reim.getReimbursementCode()));
		}
		
		return detachedCriteria;
	}
	
	public int getReimbursementFilterCount(Reimbursement reim)
	{
		DetachedCriteria detachedCriteria = createReimbursementCriteria(reim,"");
		
		detachedCriteria.setResultTransformer(detachedCriteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("autoMobileExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("entertainmentExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("miscellaneousExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("outStationExpenses", FetchMode.SELECT);
		
		return super.getObjectListCount(Reimbursement.class, detachedCriteria);
	}
	
	public List getReimbursementList(int startLimit,int endLimit,Reimbursement reim,String search_1st_order_by)
	{
		DetachedCriteria detachedCriteria =createReimbursementCriteria(reim,"");
		
		if(StringUtils.isNotBlank(search_1st_order_by))
		{
			detachedCriteria.addOrder(Order.desc(search_1st_order_by));
		}
		
		if(StringUtils.isBlank(search_1st_order_by))
		{
			detachedCriteria.addOrder(Order.desc("reimbursementId"));
		}
		detachedCriteria.setResultTransformer(detachedCriteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("autoMobileExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("entertainmentExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("miscellaneousExpenses", FetchMode.SELECT);
		detachedCriteria.setFetchMode("outStationExpenses", FetchMode.SELECT);
		
		return super.getObjectListByRange(Reimbursement.class, detachedCriteria, startLimit, endLimit);
	}
	
	public void saveReimbursement(Reimbursement reim)
	{
		super.saveOrUpdate(reim);
	}
	
	public void deleteReimbursement(Reimbursement reim)
	{
		super.delete(reim);
	}
	
	public Reimbursement getEntertainmentId(Integer reimbursementId)
	{
		return  (Reimbursement) super.find(Reimbursement.class, reimbursementId);
		
	}

	
}
*/