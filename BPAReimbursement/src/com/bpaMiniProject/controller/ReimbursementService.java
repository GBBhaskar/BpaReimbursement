package com.bpaMiniProject.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpaMiniProject.dao.AutoMobileExpenseDao;
import com.bpaMiniProject.dao.EntertainmentExpenseDao;
import com.bpaMiniProject.dao.MiscellaneousExpenseDao;
import com.bpaMiniProject.dao.OutStationExpenseDao;
import com.bpaMiniProject.dao.ReimbursementDao;
import com.bpaMiniProject.model.AutomobileExpense;
import com.bpaMiniProject.model.EntertainmentExpense;
import com.bpaMiniProject.model.MiscellaneousExpense;
import com.bpaMiniProject.model.OutStationExpense;
import com.bpaMiniProject.model.Reimbursement;

@Controller
public class ReimbursementService
{
	
	@Autowired
	private ReimbursementDao reimbursementDao;
	
	@Autowired
	private AutoMobileExpenseDao autoMobileExpenseDao;
	
	@Autowired
	private MiscellaneousExpenseDao miscellaneousExpenseDao;
	
	@Autowired
	private OutStationExpenseDao outStationExpenseDao;
	
	@Autowired
	private EntertainmentExpenseDao entertainmentExpenseDao;
	
	
	@RequestMapping(value = "/reimbursement/addReimbursement", method = RequestMethod.GET)
	public ModelAndView addReimbursement(HttpServletRequest request) 
	{
		//Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("newReimbursement");	
	}
	
	

	@RequestMapping(value = "/reimbursement/viewHome", method = RequestMethod.GET)
	public ModelAndView viewHome(HttpServletRequest request) 
	{
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		   System.out.println("UserId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+userId);
		   Integer managerId = (Integer)session.getAttribute("managerId");
		   System.out.println("managerId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+managerId);
		   
		 int page = 1;
	       int recordsPerPage = 5;
	       if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	       
		Map<String, Object> model = new HashMap<String, Object>();
		List<Reimbursement> reimbursementList = new ArrayList();
		Reimbursement searchReimbursement = new Reimbursement();
		searchReimbursement.setCreatedBy(userId);
		reimbursementList = reimbursementDao.getReimbursementList((page-1)*recordsPerPage,recordsPerPage, searchReimbursement, ""); 
		model.put("reimbursementList", reimbursementList);
		Integer count = reimbursementDao.getReimbursementFilterCount(searchReimbursement);		
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		request.setAttribute("reimbursementList", reimbursementList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		model.put("count", count);
		
		if (managerId == 0)
	       {
	    	   Reimbursement searchApprovalReimbursement=new Reimbursement();
			   searchApprovalReimbursement.setManager(userId);
			   searchApprovalReimbursement.setStatus("Submitted");
			   
			   int approvalPage = 1;
		       int approvalRecordsPerPage = 5;
		       if(request.getParameter("approvalPage") != null)
		    	   approvalPage = Integer.parseInt(request.getParameter("approvalPage"));
		       	   System.out.println("Approval Page::::::::::::::::::::::"+approvalPage);
			   
			   List<Reimbursement> reimbursementApprovalList;
			   reimbursementApprovalList=reimbursementDao.getReimbursementList((approvalPage-1)*approvalRecordsPerPage,approvalRecordsPerPage, searchApprovalReimbursement, ""); 
			   int noOfApprovalRecords = reimbursementDao.getReimbursementFilterCount(searchApprovalReimbursement);	
		       int noOfApprovalPages = (int) Math.ceil(noOfApprovalRecords * 1.0 / approvalRecordsPerPage);
			   request.setAttribute("reimbursementApprovalList", reimbursementApprovalList);	
			   request.setAttribute("noOfApprovalPages", noOfApprovalPages);
		       request.setAttribute("currentApprovalPage", approvalPage);
	       }

		return new ModelAndView("index", model);	
		
	
	}
	
	@RequestMapping(value = "/reimbursement/viewReimbursementList", method = RequestMethod.GET)
	public ModelAndView viewReimbursementList(HttpServletRequest request) 
	{
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		   System.out.println("UserId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+userId);
		   Integer managerId = (Integer)session.getAttribute("managerId");
		   System.out.println("managerId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+managerId);
		   
		 int page = 1;
	       int recordsPerPage = 25;
	       if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	       
		Map<String, Object> model = new HashMap<String, Object>();
		List<Reimbursement> reimbursementList = new ArrayList();
		Reimbursement searchReimbursement = new Reimbursement();
		searchReimbursement.setCreatedBy(userId);
		reimbursementList = reimbursementDao.getReimbursementList((page-1)*recordsPerPage,recordsPerPage, searchReimbursement, ""); 
		model.put("reimbursementList", reimbursementList);
		Integer count = reimbursementDao.getReimbursementFilterCount(searchReimbursement);		
		int noOfPages = (int) Math.ceil(count * 1.0 / recordsPerPage);
		request.setAttribute("reimbursementList", reimbursementList);	
		request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);		
		model.put("count", count);
		
		

		return new ModelAndView("myReimbursements", model);	
		
	
	}
	
	@RequestMapping(value = "/reimbursement/viewReimbursementApprovalList", method = RequestMethod.GET)
	public ModelAndView viewReimbursementApprovalList(HttpServletRequest request) 
	{
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		   System.out.println("UserId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+userId);
		   Integer managerId = (Integer)session.getAttribute("managerId");
		   System.out.println("managerId in List::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+managerId);
		   
		 
	       
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if (managerId == 0)
	       {
	    	   Reimbursement searchApprovalReimbursement=new Reimbursement();
			   searchApprovalReimbursement.setManager(userId);
			   searchApprovalReimbursement.setStatus("Submitted");
			   
			   int approvalPage = 1;
		       int approvalRecordsPerPage = 25;
		       if(request.getParameter("approvalPage") != null)
		    	   approvalPage = Integer.parseInt(request.getParameter("approvalPage"));
		       	   System.out.println("Approval Page::::::::::::::::::::::"+approvalPage);
			   
			   List<Reimbursement> reimbursementApprovalList;
			   reimbursementApprovalList=reimbursementDao.getReimbursementList((approvalPage-1)*approvalRecordsPerPage,approvalRecordsPerPage, searchApprovalReimbursement, ""); 
			   int noOfApprovalRecords = reimbursementDao.getReimbursementFilterCount(searchApprovalReimbursement);	
		       int noOfApprovalPages = (int) Math.ceil(noOfApprovalRecords * 1.0 / approvalRecordsPerPage);
			   request.setAttribute("reimbursementApprovalList", reimbursementApprovalList);	
			   request.setAttribute("noOfApprovalPages", noOfApprovalPages);
		       request.setAttribute("currentApprovalPage", approvalPage);
	       }

		return new ModelAndView("myApprovals", model);	
		
	
	}
	
	@RequestMapping(value = "/reimbursement/saveTemporaryReibursement", method = RequestMethod.POST)
	public ModelAndView saveTemporaryReimbursement(HttpServletRequest request) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		String employeeCode = (String)session.getAttribute("employeeCode");
		
		String department = request.getParameter("department");
		String purpose_of_travel = request.getParameter("purpose_of_travel");
		String supplementary_info = request.getParameter("supplementary_info");
		String amount_paid = request.getParameter("amount_paid");
		
		Reimbursement reimbursement = null;
		List<OutStationExpense> outOfStateList = new ArrayList();
		List<EntertainmentExpense>entertainmentList = new ArrayList();
		List<AutomobileExpense>automobileList = new ArrayList();
		List<MiscellaneousExpense>miscList = new ArrayList();
		
		if ((Reimbursement)session.getAttribute("reimbursement") != null)
		{
			reimbursement = (Reimbursement)session.getAttribute("reimbursement");
			if (reimbursement.getOutStationExpenses() != null)
			{
				outOfStateList = reimbursement.getOutStationExpenses();
			}
			if (reimbursement.getEntertainmentExpenses() != null)
			{
				entertainmentList = reimbursement.getEntertainmentExpenses();
			}
			if (reimbursement.getAutoMobileExpenses() != null)
			{
				automobileList = reimbursement.getAutoMobileExpenses();
			}
			if (reimbursement.getMiscellaneousExpenses() != null)
			{
				miscList = reimbursement.getMiscellaneousExpenses();
			}
			
			
		}
		else
		{
			reimbursement = new Reimbursement();
			outOfStateList = new ArrayList();
			entertainmentList = new ArrayList();
			automobileList = new ArrayList<>();
			miscList = new ArrayList();
		}
		
		if (request.getParameter("amount_paid") != null
				&& request.getParameter("amount_paid").isEmpty() == false)
		{
			reimbursement.setAdvanceAmount(Double.valueOf(request.getParameter("amount_paid")));
		}
		
		reimbursement.setCreatedBy(userId);
		reimbursement.setDepartment(department);
		reimbursement.setPurposeOfTravel(purpose_of_travel);
		reimbursement.setSupplementaryInformation(supplementary_info);
		
		
		/*OutStation Expenses*/
		
		BigDecimal total = new BigDecimal(0);
		OutStationExpense outofState = new OutStationExpense();
		String travel_on = request.getParameter("travel_on");
		System.out.println("travel_on:::::::::::::::::::::::::::::::::::::::::::::::::::::::"+travel_on);
		if (request.getParameter("travel_on") != null
				&& request.getParameter("travel_on").isEmpty() == false) 
		{
			try 
			{
				System.out.println("travel"+travel_on);
				
				System.out.println("Formatted Date::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+dateFormat.parse(travel_on));
			    outofState.setDate(dateFormat.parse(travel_on));
				System.out.println("Formatted Date from object::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+outofState.getDate());
				System.out.println("travel"+travel_on);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
		}
		String travel_to = request.getParameter("travel_to");
		outofState.setState(travel_to);
		if (request.getParameter("room_rent") != null
				&& request.getParameter("room_rent").isEmpty() == false) {
			String room_rent = request.getParameter("room_rent");
			total = total.add(BigDecimal.valueOf(Double.valueOf(room_rent).doubleValue()));
			outofState.setRoomRent(Double.valueOf(room_rent).doubleValue());
		}
		if (request.getParameter("breakfast_exp") != null
				&& request.getParameter("breakfast_exp").isEmpty() == false) {
			String breakfast_exp = request.getParameter("breakfast_exp");
			outofState.setBreakfastExpense(Double.valueOf(breakfast_exp).doubleValue());
			total = total.add(BigDecimal.valueOf(Double.valueOf(breakfast_exp).doubleValue()));
		}
		if (request.getParameter("lunch_exp") != null
				&& request.getParameter("lunch_exp").isEmpty() == false) {
			String lunch_exp = request.getParameter("lunch_exp"); 
			outofState.setLunchExpense(Double.valueOf(lunch_exp).doubleValue());
			total = total.add(BigDecimal.valueOf(Double.valueOf(lunch_exp).doubleValue()));
		}
		
		if (request.getParameter("dinner_exp") != null
				&& request.getParameter("dinner_exp").isEmpty() == false) {
			String dinner_exp = request.getParameter("dinner_exp"); 
			outofState.setDinnerExpense(Double.valueOf(dinner_exp).doubleValue());
			total = total.add(BigDecimal.valueOf(Double.valueOf(dinner_exp).doubleValue()));
		}
		
		if (request.getParameter("entertainment_exp") != null
				&& request.getParameter("entertainment_exp").isEmpty() == false) {
			String entertainment_exp = request.getParameter("entertainment_exp");
			outofState.setEntertainmentExpense(Double.valueOf(entertainment_exp).doubleValue());
			total = total.add(BigDecimal.valueOf(Double.valueOf(entertainment_exp).doubleValue()));
		}
		
		if (request.getParameter("misc_exp") != null
				&& request.getParameter("misc_exp").isEmpty() == false) {
			String misc_exp = request.getParameter("misc_exp"); 
			outofState.setMiscellaneousExpense(Double.valueOf(misc_exp).doubleValue());
			total = total.add(BigDecimal.valueOf(Double.valueOf(misc_exp).doubleValue()));
		}
		outofState.setDailyTotal(total.doubleValue());
		String description = request.getParameter("description"); 
		outofState.setDescription(description);
		
		if (request.getParameter("travel_on") != null
				&& request.getParameter("travel_on").isEmpty() == false) 
		{
			outOfStateList.add(outofState);
		}
		
		reimbursement.setOutStationExpenses(outOfStateList);
		
		System.out.println("Reimbursement code:"+reimbursement.getDepartment());
		System.out.println("Reimbursement outofstate list:"+outOfStateList.size());
		
		
		/* Entertainment Expenses*/
		
		EntertainmentExpense entertainment = new EntertainmentExpense();
		String ent_date = request.getParameter("ent_date");
		System.out.println("ent_date:::::::::::::::::::::::::::::::::::::::::::::::::::::::"+ent_date);
		if (request.getParameter("ent_date") != null
				&& request.getParameter("ent_date").isEmpty() == false) 
		{
			try 
			{
				entertainment.setDate(dateFormat.parse(ent_date));
			} 
			catch (ParseException e) 
			{
				
				e.printStackTrace();
			} 
		}
		if (request.getParameter("ent_amount") != null
				&& request.getParameter("ent_amount").isEmpty() == false) {
			String ent_amount = request.getParameter("ent_amount");
			entertainment.setAmount(Double.valueOf(ent_amount).doubleValue());
		}
		
		
		String ent_naturepurpose = request.getParameter("ent_naturepurpose");
		entertainment.setNotes(ent_naturepurpose);
		String ent_description = request.getParameter("ent_description");
		entertainment.setDescription(ent_description);
		if (request.getParameter("ent_amount") != null
				&& request.getParameter("ent_amount").isEmpty() == false) 
		{
			
			System.out.println("Entertainment Amount:"+entertainment.getAmount());
			
			entertainmentList.add(entertainment);
			reimbursement.setEntertainmentExpenses(entertainmentList);
			System.out.println("Reimbursement Entertainment list:"+entertainmentList.size());
		}
		
		
		
		
		
		/* Automobile Expenses*/
		
				AutomobileExpense automobile = new AutomobileExpense();
				String auto_date = request.getParameter("auto_date");
				System.out.println("auto_date:::::::::::::::::::::::::::::::::::::::::::::::::::::::"+auto_date);
				if (request.getParameter("auto_date") != null
						&& request.getParameter("auto_date").isEmpty() == false) 
				{
				try {
					automobile.setDate(dateFormat.parse(auto_date));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				}
				
				if (request.getParameter("auto_amount") != null
						&& request.getParameter("auto_amount").isEmpty() == false) {
					String auto_amount = request.getParameter("auto_amount");
					automobile.setAmount(Double.valueOf(auto_amount).doubleValue());
				}
				
				
				String auto_description = request.getParameter("auto_description");
				automobile.setDescription(auto_description);
				if (request.getParameter("auto_amount") != null
						&& request.getParameter("auto_amount").isEmpty() == false) {
					automobileList.add(automobile);
					reimbursement.setAutoMobileExpenses(automobileList);
					System.out.println("Reimbursement Autombile list:"+automobileList.size());
				}
				
				
				
				
				// Misc
				MiscellaneousExpense misc = new MiscellaneousExpense();
				String misc_date = request.getParameter("misc_date");
				System.out.println("misc_date:::::::::::::::::::::::::::::::::::::::::::::::::::::::"+misc_date);
				if (request.getParameter("misc_date") != null
						&& request.getParameter("misc_date").isEmpty() == false) 
				{
				try {
					misc.setDate(dateFormat.parse(misc_date));
				} catch (ParseException e) 
				{
					
					e.printStackTrace();
				}
				}
				if (request.getParameter("misc_amount") != null
						&& request.getParameter("misc_amount").isEmpty() == false) {
					String misc_amount = request.getParameter("misc_amount");
					misc.setAmount(Double.valueOf(misc_amount).doubleValue());
				}
				
				
				String misc_description = request.getParameter("misc_description");
				System.out.println(misc_description);
				misc.setDescription(misc_description);
				
				
				if (request.getParameter("misc_amount") != null
						&& request.getParameter("misc_amount").isEmpty() == false) {
					System.out.println("Misc Added **************************************************************");
					miscList.add(misc);
					reimbursement.setMiscellaneousExpenses(miscList);
					System.out.println("Reimbursement Misc list:"+miscList.size());
				}
				
				
		
		/* Storing final reimbursement in to session*/
		session.setAttribute("reimbursement", reimbursement);
		
		//RequestDispatcher rd = request.getRequestDispatcher("/jsp/addReimbursement.jsp");
		//rd.forward(request, response);
		
		
		return new ModelAndView("newReimbursement");	
		
	}
	
	
	
	@RequestMapping(value = "/reimbursement/saveAllReimbursement", method = RequestMethod.GET)
	public void saveAllReimbursement(HttpServletRequest request, HttpServletResponse response) 
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		String employee_code = (String)session.getAttribute("employee_code");
		
		Integer managerId = (Integer) session.getAttribute("managerId");
		Reimbursement reimbursement = (Reimbursement)session.getAttribute("reimbursement");
		
		String remimburseCode = "REIM-";
		 int c;
		 Random t = new Random();
		 for (c = 1; c <= 10; c++) 
		 {
		      System.out.println(t.nextInt(100));
		      remimburseCode = remimburseCode+t.nextInt(100);
		      break;
		 }
		reimbursement.setReimbursementCode(remimburseCode);
		reimbursement.setCreatedBy(userId);
		reimbursement.setCreatedOn(todayDate);
		reimbursement.setDate(todayDate);
		reimbursement.setEmployeeName(employee_code);
		BigDecimal totalReimbursementAmount = new BigDecimal(0);
		
		if (reimbursement.getEntertainmentExpenses() != null)
		{
			BigDecimal totalEntAmount = new BigDecimal(0);
			for (EntertainmentExpense ent: reimbursement.getEntertainmentExpenses())
			{
				totalEntAmount = totalEntAmount.add(BigDecimal.valueOf(ent.getAmount()));
			}
			totalReimbursementAmount = totalReimbursementAmount.add(totalEntAmount);
		}
		if (reimbursement.getAutoMobileExpenses() != null)
		{
			BigDecimal totalAutoMobileAmount = new BigDecimal(0);
			for (AutomobileExpense auto: reimbursement.getAutoMobileExpenses())
			{
				totalAutoMobileAmount = totalAutoMobileAmount.add(BigDecimal.valueOf(auto.getAmount()));
			}
			totalReimbursementAmount = totalReimbursementAmount.add(totalAutoMobileAmount);
		}
		if (reimbursement.getMiscellaneousExpenses() != null)
		{
			BigDecimal totalMiscAmount = new BigDecimal(0);
			for (MiscellaneousExpense misc: reimbursement.getMiscellaneousExpenses())
			{
				totalMiscAmount = totalMiscAmount.add(BigDecimal.valueOf(misc.getAmount()));
			}
			totalReimbursementAmount = totalReimbursementAmount.add(totalMiscAmount);
		}
		if (reimbursement.getOutStationExpenses() != null)
		{
			BigDecimal totalOutOfStateAmount = new BigDecimal(0);
			for (OutStationExpense outofstate: reimbursement.getOutStationExpenses())
			{
				totalOutOfStateAmount = totalOutOfStateAmount.add(BigDecimal.valueOf(outofstate.getDailyTotal()));
				
			}
			totalReimbursementAmount = totalReimbursementAmount.add(totalOutOfStateAmount);
		}
		reimbursement.setTotalExpense(totalReimbursementAmount.doubleValue());
		BigDecimal paidAmount = BigDecimal.valueOf(reimbursement.getAdvanceAmount());
		BigDecimal outstandingAmount = totalReimbursementAmount.subtract(paidAmount);
		reimbursement.setDueAmount(outstandingAmount.doubleValue());
		reimbursement.setStatus("submitted");
		reimbursement.setManager(managerId);
		
		
		reimbursementDao.saveReimbursement(reimbursement);
		System.out.println("Stupid program ::::::::::::::::::::::::::::::::"+reimbursement.getReimbursementId());
		
		List<AutomobileExpense> autoMobileExpenseList = reimbursement.getAutoMobileExpenses();
		if (reimbursement.getAutoMobileExpenses() != null)
		{
			for (AutomobileExpense autombileExpense :autoMobileExpenseList )
			{
				autombileExpense.setReimbursement1(reimbursement);
				autoMobileExpenseDao.saveAutoMobile(autombileExpense);
			}
		}
		
		
		List<MiscellaneousExpense> miscExpenseList = reimbursement.getMiscellaneousExpenses();
		if (reimbursement.getMiscellaneousExpenses() != null)
		{
			for (MiscellaneousExpense miscellaneousExpense :miscExpenseList )
			{
				miscellaneousExpense.setReimbursement3(reimbursement);
				miscellaneousExpenseDao.saveMiscellaneous(miscellaneousExpense);
			}
		}
		
		List<EntertainmentExpense> entertainmentList = reimbursement.getEntertainmentExpenses();
		if (reimbursement.getEntertainmentExpenses() != null)
		{
			for (EntertainmentExpense entertainmentExpense :entertainmentList )
			{
				entertainmentExpense.setReimbursement2(reimbursement);
				entertainmentExpenseDao.saveEntertainment(entertainmentExpense);
			}
		}
		List<OutStationExpense> outStationExpList = reimbursement.getOutStationExpenses();
		if (reimbursement.getOutStationExpenses() != null)
		{
		for (OutStationExpense outStationExpense :outStationExpList )
		{
			outStationExpense.setReimbursement4(reimbursement);
			outStationExpenseDao.saveOutStation(outStationExpense);
		}
		}
		
		session.removeAttribute("reimbursement");
		
		try 
		{
			response.sendRedirect("../reimbursement/viewReimbursementList.action");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@RequestMapping(value = "/reimbursement/viewReimbursemenDetail", method = RequestMethod.GET)
	public ModelAndView viewReimbursemenDetail(HttpServletRequest request) 
	{
		//Map<String, Object> model = new HashMap<String, Object>();
		
		HttpSession session=request.getSession();
		   Integer userId = (Integer)session.getAttribute("userId");
		   
		  
		   Reimbursement searchReimbursement=new Reimbursement();
		   String reimbursementId = request.getParameter("reimbursementId");
		   searchReimbursement.setReimbursementId(Integer.parseInt(reimbursementId));
		  // Reimbursement reimbursement = reimbursementDao.getReimbursementId(new Integer(reimbursementId));
		   
		   Reimbursement reimbursement = reimbursementDao.getUniqueReimbursement(searchReimbursement);
		   
		   //List<Reimbursement> reimbursementApprovalList;
		   //reimbursementApprovalList=databasepersistence.fetchApprovalList(reimbursement);
		  
		   
		   AutomobileExpense searchAutomobileExpense = new AutomobileExpense();
		   searchAutomobileExpense.setReimbursement1(reimbursement);
		   
		   List<AutomobileExpense> automobileExpList = autoMobileExpenseDao.getAllAutoMobileListByReimbursement(searchAutomobileExpense, "");
		   System.out.println("Autombile expense list dev::::::::::::::::::::::::::::::::::::::::::::::::::::::"+automobileExpList.size());
		   reimbursement.setAutoMobileExpenses(automobileExpList);
		     
		   System.out.println("after reimbursement fetch");
		   
		   
		   EntertainmentExpense searchEntertainmentExpense = new EntertainmentExpense();
		   searchEntertainmentExpense.setReimbursement2(reimbursement);
		   List<EntertainmentExpense> entertainmentList = entertainmentExpenseDao.getAllEntertainmentListByReimbursement(searchEntertainmentExpense, "");
		   System.out.println("Entertainment list dev::::::::::::::::::::::::::::::::::::::::::::::::::::::"+entertainmentList.size());
		   reimbursement.setEntertainmentExpenses(entertainmentList);
		    
		   System.out.println("after entertainment list");
		     
		   MiscellaneousExpense searchMiscellaneousExpense = new MiscellaneousExpense();
		   searchMiscellaneousExpense.setReimbursement3(reimbursement);
		   List<MiscellaneousExpense> miscellaneousList = miscellaneousExpenseDao.getAllMiscellaneousListByReimbursement(searchMiscellaneousExpense, "");
		   System.out.println("Miscellaneous list dev::::::::::::::::::::::::::::::::::::::::::::::::::::::"+miscellaneousList.size());
		   reimbursement.setMiscellaneousExpenses(miscellaneousList);
		     
		   System.out.println("after miscellaneous list");
		     
		    
		   OutStationExpense searchOutStationExpense = new OutStationExpense();
		   searchOutStationExpense.setReimbursement4(reimbursement);
		   List<OutStationExpense> outofstateList = outStationExpenseDao.getAllOutStationListByReimbursement(searchOutStationExpense, "");
		   System.out.println("OutStation list dev::::::::::::::::::::::::::::::::::::::::::::::::::::::"+outofstateList.size());
		   reimbursement.setOutStationExpenses(outofstateList);
		  
		   request.setAttribute("reimbursement", reimbursement);
		   
		   return new ModelAndView("viewReimbursementDetails");	
	}
	
	@RequestMapping(value = "/reimbursement/approveReimbursement", method = RequestMethod.POST)
	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) 
	{

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar currentDate = Calendar.getInstance();
		Date todayDate = currentDate.getTime();
		
		HttpSession session=request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (request.getParameter("reimbursementId") != null && request.getParameter("reimbursementId").isEmpty() == false) {
		
			Reimbursement reimbursement = reimbursementDao.getReimbursementId(new Integer(request.getParameter("reimbursementId")));
			
			if (request.getParameter("approve_status") != null
					&& request.getParameter("approve_status").isEmpty() == false) {
			
				String approvalStatus = request.getParameter("approve_status");
				if (approvalStatus.equalsIgnoreCase("A"))
				{
					reimbursement.setStatus("Approved");
				}
				else
				{
					reimbursement.setStatus("Rejected");
				}
				
				
			}
			if (request.getParameter("approver_comments") != null
					&& request.getParameter("approver_comments").isEmpty() == false) {
				reimbursement.setApproverComments(request.getParameter("approver_comments"));
			}
			reimbursement.setUpdatedBy(userId);
			reimbursement.setUpdatedOn(todayDate);
			reimbursementDao.saveReimbursement(reimbursement);
			
			try 
			{
				response.sendRedirect("../reimbursement/viewReimbursementList.action");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
