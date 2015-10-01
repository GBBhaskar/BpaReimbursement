package com.bpaMiniProject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpaMiniProject.dao.ReimbursementDao;
import com.bpaMiniProject.dao.UserDao;
import com.bpaMiniProject.model.User;

@Controller
public class UserController 
{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ReimbursementDao reimbursementDao;
	
	@RequestMapping(value = "/loginVerification", method = RequestMethod.POST)
	public void loginVerification(HttpServletRequest request, HttpServletResponse response)
	{
		
		//Map<String, Object> model = new HashMap<String, Object>();
		String email = request.getParameter("userEmail");
		String password = request.getParameter("password");
		
		User searchUser = new User();
		searchUser.setUserEmail(email);
		searchUser.setPassword(password);
		
		User loggedInVerifiedUser = userDao.getUserByEmailAndPassword(searchUser);
		if (loggedInVerifiedUser!= null)
		{
			HttpSession session=request.getSession();
			
			session.setAttribute("userId",loggedInVerifiedUser.getUserId());
			session.setAttribute("user_name",loggedInVerifiedUser.getUserName());
			session.setAttribute("managerId",loggedInVerifiedUser.getManagerId());
			session.setAttribute("userEmail",loggedInVerifiedUser.getUserEmail());
			session.setAttribute("employee_code", loggedInVerifiedUser.getEmployeeCode());
			//session.setAttribute("project_master_id", loggedInVerifiedUser.get);
			
			try 
			{
				response.sendRedirect("reimbursement/viewHome.action");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			/*Reimbursement reimbursement= new Reimbursement();
			reimbursement.setCreatedBy(loggedInVerifiedUser.getUserId());
			reimbursement.setEmployeeName(loggedInVerifiedUser.getUserName());
			
			List<Reimbursement> reimbursementList = new ArrayList();
			Reimbursement searchReimbursement = new Reimbursement();
			reimbursementList = reimbursementDao.getReimbursementList(0, 10, searchReimbursement, ""); 
			
			
			model.put("reimbursementList", reimbursementList);
			//session.setAttribute("reimbursementsLists", reimbursementList);
			Integer count = reimbursementDao.getReimbursementFilterCount(searchReimbursement);
			model.put("count", count);
			mv.setViewName("reimbursementView");
			mv.addAllObjects(model);*/
		}
		else
		{
			//mv.setViewName("login");
			try 
			{
				response.sendRedirect("./");
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView addReimbursement(HttpServletRequest request) 
	{
		HttpSession session=request.getSession();
		session.invalidate();
		//Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("login");	
	}
}
