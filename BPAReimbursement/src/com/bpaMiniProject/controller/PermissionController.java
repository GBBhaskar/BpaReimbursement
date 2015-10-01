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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpaMiniProject.dao.PermissionDao;
import com.bpaMiniProject.model.Permission;

@Controller
public class PermissionController
{
	
	@Autowired
	private PermissionDao permissionDao;
	
	@RequestMapping(value = "/permission/viewPermissionList", method = RequestMethod.GET)
	public ModelAndView viewPermissionList(HttpServletRequest request) 
	{
		
		HttpSession session=request.getSession();
		
		 int page = 1;
	     int recordsPerPage = 5;
	     if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	     
	     Permission searchPermission = new Permission();
	     if (request.getParameter("permisssionName") != null
					&& request.getParameter("permisssionName").isEmpty() == false)
	     	{
	    	 searchPermission.setPermisssionName(request.getParameter("permisssionName"));
		    }
	       
		Map<String, Object> model = new HashMap<String, Object>();
		List<Permission> permissionList = new ArrayList();
		
		permissionList =permissionDao.getPermissionList((page-1)*recordsPerPage, recordsPerPage, searchPermission,"");
		model.put("permissionList", permissionList);	
		Integer count=permissionDao.getPermissionFilterCount(searchPermission);
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		request.setAttribute("permissionList", permissionList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		model.put("count", count);
		return new ModelAndView("", model);	
	
	}
	
	@RequestMapping(value = "/permission/savePermission", method = RequestMethod.POST)
	public void savePermission(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		int page = 1;
	    int recordsPerPage = 5;
	    if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	    
	    Permission permission = new Permission();
	    if (request.getParameter("permissionId") != null
				&& request.getParameter("permissionId").isEmpty() == false) {
	    	 Permission existingPermission = permissionDao.getPermissionById(new Integer(request.getParameter("permissionId")));
	    	if (existingPermission != null)
	    	{
	    		permission.setPermissionId(existingPermission.getPermissionId());;
	    		permission.setUpdatedBy(userId);
	    		permission.setUpdatedOn(todayDate);
	    	}
	    	else
	    	{
	    		permission.setCreatedBy(userId);
	    		permission.setCreatedOn(todayDate);
	    	}
	    }
	    if (request.getParameter("permisssionName") != null
				&& request.getParameter("permisssionName").isEmpty() == false) {
	    	permission.setPermisssionName(request.getParameter("permisssionName"));
	    }
	    if (request.getParameter("permissionDescription") != null
				&& request.getParameter("permissionDescription").isEmpty() == false) {
	    	permission.setPermissionDescription(request.getParameter("permissionDescription"));
	    }
	    
	    // Need to write code later for getting active/inactive
	    
	    permission.setIsActive(true);
	   
	    permissionDao.savePermission(permission);
	    
	    try 
		{
			response.sendRedirect("../permission/viewPermissionList.action");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/permission/deletePermission", method = RequestMethod.GET)
	public void deletePermission(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (request.getParameter("permissionId") != null
				&& request.getParameter("permissionId").isEmpty() == false) {
			Permission permission = permissionDao.getPermissionById(new Integer(request.getParameter("permissionId")));
			if (permission != null)
			{
				permission.setIsActive(false);
				permission.setUpdatedBy(userId);
				permission.setUpdatedOn(todayDate);
				permissionDao.savePermission(permission);
			}
			try 
			{
					response.sendRedirect("../permission/viewPermissionList.action");
			} 
			catch (IOException e) 
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
	
	}
	

	
}
