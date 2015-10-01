package com.bpaMiniProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bpaMiniProject.model.User;

@Repository("UserDao")
public class UserDao 
{

	 @Autowired
	 private SessionFactory sessionFactory;
	               
	 private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	    
	private Criteria createUserCriteria(Session session,User user,String matchType)
	{
		Criteria criteria = session.createCriteria(User.class);
		
		if(user.getUserEmail() !=null)
		{
			if (matchType.equalsIgnoreCase("exact"))
			{
				criteria.add(Restrictions.eq("userEmail",user.getUserEmail()));
				
			}
			else
			{
				criteria.add(Restrictions.like("userEmail","%"+user.getUserEmail()+"%"));
			}
		}
		if(user.getPassword() !=null)
		{
			if (matchType.equalsIgnoreCase("exact"))
			{
				criteria.add(Restrictions.eq("password",user.getPassword()));
			}			
		}
		
		return criteria;
	}

	
	public User getUserByEmailAndPassword(User user)
	{
		Session session = sessionFactory.openSession();
        User userObj = null;                 
        try
        {
        	 Criteria criteria = createUserCriteria(session,user,"exact");
             List list = criteria.list();
             if (criteria.list().size() != 0) 
             {
            	 userObj = (User)criteria.list().get(0);
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
         return userObj;
     }  
}

