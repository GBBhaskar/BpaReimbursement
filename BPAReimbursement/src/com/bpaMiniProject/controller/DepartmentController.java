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

import com.bpaMiniProject.dao.DepartmentDao;
import com.bpaMiniProject.model.Department;

@Controller
public class DepartmentController
{
	@Autowired
	private DepartmentDao departmentDao;
	
	
	@RequestMapping(value = "/department/viewDepartmentList", method = RequestMethod.GET)
	public ModelAndView viewDepartmentList(HttpServletRequest request) 
	{
		
		HttpSession session=request.getSession();
		int page = 1;
	    int recordsPerPage = 5;
	    if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	    
	    Department searchDepartment = new Department();
	    if (request.getParameter("departmentName") != null
				&& request.getParameter("departmentName").isEmpty() == false) {
	    	searchDepartment.setDepartmentName(request.getParameter("departmentName"));
	    }
	    
		Map<String, Object> model = new HashMap<String, Object>();
		List<Department> departmentList = new ArrayList();
		departmentList =departmentDao.getDepartmentList((page-1)*recordsPerPage, recordsPerPage, searchDepartment,"");
		model.put("departmentList", departmentList);	
		Integer count=departmentDao.getDeparmentFilterCount(searchDepartment);
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		request.setAttribute("departmentList", departmentList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		model.put("count", count);
		return new ModelAndView("departmentView", model);	
		
	
	}
	
	@RequestMapping(value = "/department/saveDepartment", method = RequestMethod.POST)
	public void saveDepartment(HttpServletRequest request, HttpServletResponse response) 
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
	    
	    Department department = new Department();
	    if (request.getParameter("departmentId") != null
				&& request.getParameter("departmentId").isEmpty() == false) {
	    	Department existingDepartment = departmentDao.getDepartmentById(new Integer(request.getParameter("departmentId")));
	    	if (existingDepartment != null)
	    	{
	    		department.setDepartmentId(existingDepartment.getDepartmentId());
	    		department.setUpdatedBy(userId);
	    	    department.setUpdatedOn(todayDate);
	    	}
	    	else
	    	{
	    		 department.setCreatedBy(userId);
	    		 department.setCreatedOn(todayDate);
	    	}
	    	
	    }
	    else
    	{
    		 department.setCreatedBy(userId);
    		 department.setCreatedOn(todayDate);
    	}
	    if (request.getParameter("departmentName") != null
				&& request.getParameter("departmentName").isEmpty() == false) {
	    	department.setDepartmentName(request.getParameter("departmentName"));
	    }
	    if (request.getParameter("departmentDescription") != null
				&& request.getParameter("departmentDescription").isEmpty() == false) {
	    	department.setDepartmentDescription(request.getParameter("departmentDescription"));
	    }
	    
	    // will write code later for getting active/inactive
	    
	    department.setIsActive(true);
	   
	    departmentDao.saveDepartment(department);
	    
	    try 
		{
			response.sendRedirect("../department/viewDepartmentList.action");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	
	}
	
	@RequestMapping(value = "/department/deleteDepartment", method = RequestMethod.GET)
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (request.getParameter("departmentId") != null
				&& request.getParameter("departmentId").isEmpty() == false) {
			Department department = departmentDao.getDepartmentById(new Integer(request.getParameter("departmentId")));
			if (department != null)
			{
				department.setIsActive(false);
				department.setUpdatedBy(userId);
	    	    department.setUpdatedOn(todayDate);
	    	    departmentDao.saveDepartment(department);
			}
			try 
			{
					response.sendRedirect("../department/viewDepartmentList.action");
			} 
			catch (IOException e) 
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
	
	}
	
}
