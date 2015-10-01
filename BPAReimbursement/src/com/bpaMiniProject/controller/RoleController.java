package com.bpaMiniProject.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpaMiniProject.dao.RoleDao;
import com.bpaMiniProject.model.Role;

@Controller
public class RoleController
{
	
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping(value = "/role/addRole", method = RequestMethod.GET)
	public ModelAndView addRole(HttpServletRequest request, Model model) 
	{
		//Map<String, Object> model = new HashMap<String, Object>();
		Role newRole = new Role();
		model.addAttribute("role", newRole);	
		return new ModelAndView("editRole");	
	}
	
	@RequestMapping(value = "/role/editRole", method = RequestMethod.GET)
	public ModelAndView editRole(HttpServletRequest request,Model model) 
	{
		
		if (request.getParameter("roleId") != null
				&& request.getParameter("roleId").isEmpty() == false)
	    {
	    	 Role existingRole = roleDao.getRoleById(new Integer(request.getParameter("roleId")));
	    	 model.addAttribute("role", existingRole);	
	    	//request.setAttribute("role", existingRole);	
	    }
		return new ModelAndView("editRole");	
	}
	
	
	@RequestMapping(value = "/role/viewRoleList", method = RequestMethod.GET)
	public ModelAndView viewRoleList(HttpServletRequest request,Model model) 
	{
		
		HttpSession session=request.getSession();
		 int page = 1;
	     int recordsPerPage = 5;
	   
	     if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	     
	     
	 	 Role searchRole = new Role();
	 	if (request.getParameter("roleName") != null
				&& request.getParameter("roleName").isEmpty() == false)
     	{
	 		searchRole.setRoleName(request.getParameter("roleName"));
	    }
	     
		List<Role> roleList = new ArrayList();
	
		roleList =roleDao.getRoleList((page-1)*recordsPerPage, recordsPerPage, searchRole,"");
	
		//model.put("roleList", roleList);	
		model.addAttribute("roleList", roleList);	
		Integer count=roleDao.getRoleFilterCount(searchRole);
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		//request.setAttribute("roleList", roleList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		//model.put("count", count);
	    model.addAttribute("count",count);
		
		return new ModelAndView("roleView");	
	
	}
	
	
	
	@RequestMapping(value = "/role/saveRole", method = RequestMethod.POST)
	public void saveRole(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
	    
	    Role role = new Role();
	    if (request.getParameter("roleId") != null
				&& request.getParameter("roleId").isEmpty() == false)
	    {
	    	 role = roleDao.getRoleById(new Integer(request.getParameter("roleId")));
	    	 if(role!=null)
	    	{
	    		role.setUpdatedBy(userId);
	    		role.setUpdatedOn(todayDate);
	    	}
	    	else
	    	{
	    		role.setCreatedBy(userId);
	    		role.setCreatedOn(todayDate);
	    	}
	    }
	    else
	    {
	    	role.setCreatedBy(userId);
    		role.setCreatedOn(todayDate);
	    }
	    if (request.getParameter("roleName") != null
				&& request.getParameter("roleName").isEmpty() == false) 
	    {
	    	role.setRoleName((request.getParameter("roleName")));
	    }
	    if (request.getParameter("roleDescription") != null
				&& request.getParameter("roleDescription").isEmpty() == false)
	    {
	    	role.setRoleDescription((request.getParameter("roleDescription")));
	    }
	    if (request.getParameter("isActive") != null
				&& request.getParameter("isActive").isEmpty() == false)
	    {
	    	if (request.getParameter("isActive").equalsIgnoreCase("on"))
	    	{
	    		role.setIsActive(true);
	    	}
	    	else
	    	{
	    		role.setIsActive(false);
	    	}
	    }
	    else
	    {
	    	role.setIsActive(false);
	    }
	    roleDao.saveRole(role);
	    
	    try 
		{
			response.sendRedirect("../role/viewRoleList.action");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/role/deleteRole", method = RequestMethod.GET)
	public void deleteRole(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (request.getParameter("roleId") != null
				&& request.getParameter("roleId").isEmpty() == false) {
			Role role=roleDao.getRoleById(new Integer(request.getParameter("roleId")));
			if (role != null)
			{
				role.setIsActive(false);
				role.setUpdatedBy(userId);
				role.setUpdatedOn(todayDate);
				roleDao.saveRole(role);
			}
			try 
			{
					response.sendRedirect("../role/viewRoleList.action");
			} 
			catch (IOException e) 
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}

	}

}
