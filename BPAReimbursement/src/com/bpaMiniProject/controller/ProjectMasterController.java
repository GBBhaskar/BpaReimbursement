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

import com.bpaMiniProject.dao.ProjectMasterDao;
import com.bpaMiniProject.model.ProjectMaster;

@Controller
public class ProjectMasterController
{
	@Autowired
	private ProjectMasterDao projectMasterDao;
	
	
	@RequestMapping(value = "/projectMaster/viewProjectMasterList", method = RequestMethod.GET)
	public ModelAndView viewProjectMasterList(HttpServletRequest request,Model model) 
	{
		
		HttpSession session=request.getSession();
		 int page = 1;
	     int recordsPerPage = 5;

	     if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	     
		 ProjectMaster searchProjectMaster = new ProjectMaster();
		 if (request.getParameter("projectName") != null
					&& request.getParameter("projectName").isEmpty() == false)
	     	{
			 searchProjectMaster.setProjectName(request.getParameter("projectName"));
		    }
	       
		//Map<String, Object> model = new HashMap<String, Object>();
		List<ProjectMaster> projectMasterList = new ArrayList();
		projectMasterList =projectMasterDao.getProjectMasterList((page-1)*recordsPerPage, recordsPerPage, searchProjectMaster,"");
		//model.put("projectMasterList", projectMasterList);
		model.addAttribute("projectMasterList",projectMasterList);
		Integer count=projectMasterDao.getProjectMasterFilterCount(searchProjectMaster);
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		request.setAttribute("projectMasterList", projectMasterList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		//model.put("count", count);
	    model.addAttribute("count",count);
	    return new ModelAndView("projectMasterView");	
	
	}
	
	
	@RequestMapping(value = "/projectMaster/editProjectMaster", method = RequestMethod.GET)
	public ModelAndView editProjectMaster(HttpServletRequest request,Model model) 
	{
		//Map<String, Object> model = new HashMap<String, Object>();
		
		if (request.getParameter("projectMasterId") != null
				&& request.getParameter("projectMasterId").isEmpty() == false)
	    {
	    	 ProjectMaster existingProjectMaster = projectMasterDao.getProjectMasterById(new Integer(request.getParameter("projectMasterId")));
	    	 model.addAttribute("projectMaster", existingProjectMaster);
	    	 //request.setAttribute("projectMaster", existingProjectMaster);
	    }
		 
		return new ModelAndView("editProjectMaster");	
	}
	
	@RequestMapping(value ="/projectMaster/saveProjectMaster", method = RequestMethod.POST)
	public void saveProjectMaster(HttpServletRequest request, HttpServletResponse response) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		String userName=(String)session.getAttribute("user_name");
		System.out.println("the username is::::::::::::::::::::::::::::"+userName);
		System.out.println("the userName is::::::::::::::::::::::"+userName);
		
		//System.out.println("the userId is"+userId);
		//String creatorName=(String)session.getAttribute("EmployeeName");
		int page = 1;
	    int recordsPerPage = 5;
	    if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	    
	    ProjectMaster projectMaster = new ProjectMaster();
	    //projectMaster.setCreatedBy((Integer.parseInt(userName)));
	    //System.out.println("the created by is:::::::::::::::::::::::::::::::::::::"+projectMaster.getCreatedBy());
	    if (request.getParameter("projectMasterId") != null
				&& request.getParameter("projectMasterId").isEmpty() == false)
	    {
	    	 projectMaster= projectMasterDao.getProjectMasterById(new Integer(request.getParameter("projectMasterId")));
	    	 if(projectMaster!=null)
	    	{
	    		//projectMaster.setProjectMasterId(existingProjectMaster.getProjectMasterId());
	    		projectMaster.setUpdatedBy(userId);
	    		projectMaster.setUpdatedOn(todayDate);
	    	}
	    	else
	    	{
	    		projectMaster.setCreatedBy(userId);
	    		projectMaster.setCreatedOn(todayDate);
	    		//projectMaster.setCreatedBy);
	    	}
	    }
	    if (request.getParameter("projectName") != null
				&& request.getParameter("projectName").isEmpty() == false) 
	    {
	    	projectMaster.setProjectName((request.getParameter("projectName")));
	    }
	    if (request.getParameter("projectDescription") != null
				&& request.getParameter("projectDescription").isEmpty() == false)
	    {
	    	projectMaster.setProjectDescription((request.getParameter("projectDescription")));
	    }
	    
	    // Need to write code later for getting active/inactive
	    
	    projectMaster.setIsActive(true);
	    if(request.getParameter("isActive") != null  && request.getParameter("isActive").isEmpty() == false)
	    {
	       if(request.getParameter("isActive").equalsIgnoreCase("on"))
	       {
	    	   projectMaster.setIsActive(true);
	       }
	       else 
	       {
	    	  projectMaster.setIsActive(true);
	    	}
	    }else
	    {    System.out.println("checkbox is not selected,so false");
	    	 projectMaster.setIsActive(false);
	    }
	    projectMasterDao.saveProjectMaster(projectMaster);
	    
	    try 
		{
			response.sendRedirect("../projectMaster/viewProjectMasterList.action");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/projectMaster/deleteProjectMaster", method = RequestMethod.GET)
	public ModelAndView deleteProjectMaster(HttpServletRequest request, HttpServletResponse response,Model model) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int page=1;
		int recordsPerPage=5;
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		if (request.getParameter("projectMasterId") != null
				&& request.getParameter("projectMasterId").isEmpty() == false) {
			ProjectMaster projectMaster=projectMasterDao.getProjectMasterById(new Integer(request.getParameter("projectMasterId")));
			if (projectMaster != null)
			{
				projectMaster.setIsActive(true);
				projectMaster.setUpdatedBy(userId);
				projectMaster.setUpdatedOn(todayDate);
				//projectMaster.setProjectMasterId(projectMaster.getProjectMasterId());
				//System.out.println("the projectMasterId is::::::::::::::::::::::::::::::"+projectMaster.getProjectMasterId());
				//projectMasterDao.saveProjectMaster(projectMaster);
				projectMasterDao.removeProjectMaster(projectMaster.getProjectMasterId());
				System.out.println("the projectMasterId is:::::::::::::::::::::::::"+projectMaster.getProjectMasterId());
				//projectMasterDao.saveProjectMaster(projectMaster);
			}
			ProjectMaster searchProjectMaster=new ProjectMaster();
			List<ProjectMaster> projectMasterList = new ArrayList();
			projectMasterList=projectMasterDao.getProjectMasterList(0,recordsPerPage,searchProjectMaster,"");
			model.addAttribute("projectMasterList",projectMasterList);
			Integer count=projectMasterDao.getProjectMasterFilterCount(searchProjectMaster);
			int noOfPages = (int) Math.ceil(count * 1.0);
			//request.setAttribute("roleList", roleList);	
			request.setAttribute("noOfPages", noOfPages);
		    request.setAttribute("currentPage", 1);		
			//model.put("count", count);
		    model.addAttribute("count",count);
}
	return new ModelAndView("projectMasterView");
}
}
