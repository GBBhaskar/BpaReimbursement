<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.io.*,com.bpaMiniProject.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>BPA TECHNOLOGIES</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="../js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="../lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/style-responsive.css" rel="stylesheet">
	

    <link href="../css/table-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="all" href="../css/jsDatePick_ltr.min.css" />

	<script type="text/javascript" src="../js/jsDatePick.min.1.3.js"></script>
    <script src="../js/chart-master/Chart.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>BPA TECHNOLOGIES</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="../img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="../img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="../img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="../img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="../logout.action">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="../img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">INTRANET</h5>
              	  	
                  <li class="mt">
                      <a href="viewHome.action">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Reimbursement</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="viewReimbursementList.action">My Reimbursements</a></li>
                          <li class="active"><a  href="addReimbursement.action">Add Reimbursement</a></li>
                          <li ><a  href="viewReimbursementApprovalList.action">Approvals</a></li>
                      </ul>
                  </li>
				  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Projects</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="blank.html">Projects List</a></li>
                          <li><a  href="login.html">Create Project</a></li>                          
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>Timesheets</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component.html">My Timesheet</a></li>
                          <li><a  href="form_component.html">My Approvals</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>Reports</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component.html">Report1</a></li>
                          <li><a  href="form_component.html">Report2</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Administration</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="calendar.html">Users</a></li>
                          <li><a  href="gallery.html">Roles</a></li>
                          <li><a  href="todo_list.html">Departments</a></li>                         
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
   
     <%
		Integer userId = (Integer) session.getAttribute("userId");
		String employeeCode = (String) session.getAttribute("employee_code");
		Reimbursement reimbursement = (Reimbursement)session.getAttribute("reimbursement");
 
		String department = "";
		String purpose_of_travel = "";
		String supplementary_info = "";
		double advanceAmount = 0.0;
		if (reimbursement != null)
		{
			department = reimbursement.getDepartment();
			purpose_of_travel = reimbursement.getPurposeOfTravel();
			supplementary_info = reimbursement.getSupplementaryInformation();
			advanceAmount = reimbursement.getAdvanceAmount();
		}
	%>
	<%
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YYYY");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date todayDate = (Date) formatter.parse(formatter
				.format(currentDate.getTime()));
		String todayDateString = formatter1.format(todayDate);
	%>
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Reimbursements</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i>New Reimbursement</h4>
                          <section id="unseen">
                          <form method="post" name="outstationform" action="../reimbursement/saveTemporaryReibursement.action">
                          <p align="right">
                          <a href="../reimbursement/saveAllReimbursement.action">
                          <button type="button" class="btn btn-primary">Save All</button></a>&nbsp;&nbsp;
                          
                          </p>
                          
                         <!--  <div id="outstationtable" style="display: none;"> -->
                          <table class="table table-bordered table-striped table-condensed">
                          
                          <tr>
								<td>Employee Code</td>
								<td><%=employeeCode%></td>
								
								<td>Applied On</td>
								<td><%=todayDateString%></td>
							</tr>
							<tr>
								<td>Department</td>
								<td><input type="text" name="department" value="<%= department %>" /></td>
								<td>Purpose of Travel</td>
								<td><input type="text" name="purpose_of_travel" value="<%= purpose_of_travel %>" /></td>
							</tr>
							<tr>
								<td>Amount Paid by Company</td>
								<td><input type="text" name="amount_paid" value="<%= advanceAmount %>" /></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Supplementary Information</td>
								<td colspan="3"><textarea rows="4" cols="135"
										name="supplementary_info"><%=supplementary_info%></textarea></td>
							</tr>
							<tr>
								<td>Reimbursement Type</td>
								<td colspan="3"><input type=checkbox name="outstation"
									onclick="showMeOutstation('outstation')">
									&nbsp;&nbsp;Outstation reimbursement &nbsp;&nbsp; <input
									type=checkbox name="entertainment"
									onclick="showMeEntertainment('entertainment')">
									&nbsp;&nbsp;Entertainment expense &nbsp;&nbsp; <input type=checkbox
									name="auto" onclick="showMe('automobile')">
									&nbsp;&nbsp;Automobile expense &nbsp;&nbsp; <input type=checkbox
									name="misc" onclick="showMeMisc('misc')">&nbsp;&nbsp;Miscellaneous
									expense</td>
							</tr>
                          
                          
                          </table>
                      <!--     </div> -->
                          
                           <div  id="outstation" style="display: none;">
                          <table class="table table-bordered table-striped table-condensed">
			
						<tr><td colspan="4"><h4>
							<!-- <b>OutStation Expenses</b> -->
							 <h4><i class="fa fa-angle-right"></i>OutStation Expenses</h4>
							</h4></td></tr>
							<tr>
								<td>Travel On</td>
								<td>
								<input type="text"   name="travel_on"  id="travel_on"/></a>
								
								</td>
								<td>Travel To</td>
								<td><input type="text" name="travel_to" value="" /></td>
							</tr>
							<tr>
								<td>Room Rent</td>
								<td><input type="text" name="room_rent" value="" /></td>
								<td>Mode of Travel</td>
								<td><select name="mode_of_travel"><option selected value="0">--Select--</option>
								<option value="1">Auto</option>
								<option value="1">Car</option>
								<option value="1">Road</option>
								<option value="1">Train</option>
								<option value="1">Flight</option>
								</select></td>
							</tr>
							<tr>
								<td>Breakfast Expenses</td>
								<td><input type="text" name="breakfast_exp" value="" /></td>
								<td>Lunch Expenses</td>
								<td><input type="text" name="lunch_exp" value="" /></td>
							</tr>
							<tr>
								<td>Dinner Expenses</td>
								<td><input type="text" name="dinner_exp" value="" /></td>
								<td>Entertainment Expenses</td>
								<td><input type="text" name="entertainment_exp" value="" /></td>
							</tr>
							<tr>
								<td>Misc. Expenses</td>
								<td><input type="text" name="misc_exp" value="" /></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Description </td>
								<td colspan="3"><textarea rows="4" cols="135"
										name="description"></textarea></td>
							</tr>
							<tr>
								<td colspan="4" align="right">
									 <!--  <a href="JavaScript:onclick=window.history.back()" class="myButton">Save</a> -->
									 <input type="submit" name="Save" value="Save" class="btn btn-primary">
									 
									 
								</td>
							</tr>
						  
						</table>     
						</div>
						
						
						
					<div id="outstation" style="display: none;">
						<table class="table table-bordered table-striped table-condensed">
		 
                   <tr>
	<td >Date</td><td>State</td><td>Description</td><td>RoomRent</td>
	<td>CarRent</td><td>AutoMobileExpense</td><td>BreakFastExpense</td><td>LunchExpense</td>
	<td>DinnerExpense</td><td>EntertainmentExpense</td><td>MiscellaneousExpense</td><td>DailyTotal</td>
</tr>
<%  
	if (reimbursement != null)
	{
		if (reimbursement.getOutStationExpenses() != null)
		{
%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
%>
<%
for(OutStationExpense outstt:reimbursement.getOutStationExpenses())
	{
		String outOfStateDate = sdf.format(outstt.getDate());
%>
	<tr>
	
	<td><%=outOfStateDate %></td>
	<td><%=outstt.getState() %></td>
	<td><%=outstt.getDescription() %></td>
	<td><%=outstt.getRoomRent() %></td>
	<td><%=outstt.getCarRental() %></td>
	<td><%=outstt.getAutomobileExpense() %></td>
	<td><%=outstt.getBreakfastExpense() %></td>
	<td><%=outstt.getLunchExpense() %></td>
	<td><%=outstt.getDinnerExpense() %></td>
	<td><%=outstt.getEntertainmentExpense() %></td>
	<td><%=outstt.getMiscellaneousExpense() %></td>
	<td><%=outstt.getDailyTotal() %></td>
	</tr>
<%
	}
%>
			<%
				}
		}
			%>

		</table>
		</div>
		
		
		           <div id="entertainmenttable" style="display: none">
            <table class="table table-bordered table-striped table-condensed">
			
			<tr><td colspan="4"><h4>
			<!-- <b>Entertainment Expenses</b> -->
			 <h4><i class="fa fa-angle-right"></i>Entertainment Expenses</h4>
		</h4></td></tr>
			<tr>
				<td>Expense Date</td>
				<td>
				 <input type="text"  name="ent_date" id="ent_date"/>
				
				</td>
				<td>Nature & Purpose</td>
				<td><input type="text" name="ent_naturepurpose" value="" /></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td>
				 <input type="text"  name="ent_amount" />
				
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td>Description </td>
				<td colspan="3"><textarea rows="4" cols="135"
						name="ent_description"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<!-- <a href="JavaScript:onclick=window.history.back()" class="myButton">Save</a>  -->
					<input type="submit" name="Save" value="Save" class="btn btn-primary">
				</td>
			</tr>
		  
		</table>          
		</div>
		
		
			<div class="CSSTableGenerator" id="entertainment" style="display: none;">
		<table class="table table-bordered table-striped table-condensed">
			<tr>
				<td>Date</td>
				<td>Nature & Purpose</td>
				<td>Description</td>
				<td>Amount</td>
			</tr>
		
		<%
		if (reimbursement != null)
		{
			if (reimbursement.getEntertainmentExpenses() != null)
			{
			%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
%>
			<%
		for(EntertainmentExpense e:reimbursement.getEntertainmentExpenses())
		{
			String EntertainmentDate = sdf.format(e.getDate());
		%>
			
			<tr>
			<td><%= EntertainmentDate %></td>
			<td><%= e.getNotes() %></td>
			<td><%= e.getDescription()%></td>
			<td><%= e.getAmount() %></td>
			
			</tr>
			
		<%
			}
	}}
		%>
		</table>
		</div>
		<div id="misctable" style="display: none">
		<table class="table table-bordered table-striped table-condensed" >
			
			<tr><td colspan="4"><h4>
			 <h4><i class="fa fa-angle-right"></i>Miscellaneous Expenses</h4>
		</h4></td></tr>
			<tr>
				<td>Expense Date</td>
				<td>
				 <input type="text"  name="misc_date" id="misc_date"/>
				
				</td>
				<td>Amount</td>
				<td>
				 <input type="text"  name="misc_amount" />
				
				</td>
				
			</tr>
			
			<tr>
				<td>Description </td>
				<td colspan="3"><textarea rows="4" cols="135"
						name="misc_description"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<!-- <a href="JavaScript:onclick=window.history.back()" class="myButton">Save</a>  -->
					<input type="submit" name="Save" value="Save" class="btn btn-primary">
				</td>
			</tr>
		  
		</table>
		</div>
		<div id="misc" style="display:none">
		<table class="table table-bordered table-striped table-condensed" >
			<tr>
				<td>Date</td>
				<td>Description</td>
				<td>Amount</td>
			</tr>
			
			  <%
			  if (reimbursement != null)
				{
				   if (reimbursement.getMiscellaneousExpenses() != null)
				   {
					   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
for(MiscellaneousExpense mis:reimbursement.getMiscellaneousExpenses())
	{
	String MiscellaneousDate = sdf.format( mis.getDate());
%>
	<tr>
	<td><%=MiscellaneousDate%></td>
	<td><%=mis.getDescription() %></td>
	<td><%=mis.getAmount()%></td>
	</tr>
<%
	}}}
%>

		</table>
		</div>
		
		
		<div id="automobiletable" style="display: none">
		<table class="table table-bordered table-striped table-condensed">
			
			<tr><td colspan="4"><h4>
			<!-- <b>Automobile Expenses</b> -->
			 <h4><i class="fa fa-angle-right"></i>Automobile Expenses</h4>
		</h4></td></tr>
			<tr>
				<td>Expense Date</td>
				<td >
				 <input type="text"  name="auto_date" id="auto_date"/>
				 
				
				
				</td>
				<td>Amount</td>
				<td >
				 <input type="text"  name="auto_amount" />
				
				</td>
				
			</tr>
			
			<tr>
				<td>Description </td>
				<td colspan="3"><textarea rows="4" cols="135"
						name="auto_description"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<!-- <a href="JavaScript:onclick=window.history.back()" class="myButton">Save</a>  -->
					<input type="submit" name="Save" value="Save" class="btn btn-primary">
				</td>
			</tr>
		  
		</table>
		</div>
		
		
		
		<h4>
			<font color="white">Automobile Expenses</font>
		</h4>
		
		<div id="automobile" style="display: none;">
		<table class="table table-bordered table-striped table-condensed">
			<tr>
				<td>Date</td>
				<td>Description</td>
				<td>Amount</td>
			</tr>
		   <%
		   if (reimbursement != null)
			{
			   if (reimbursement.getAutoMobileExpenses() != null)
			   {
				  
				   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
				    
					for(AutomobileExpense au:reimbursement.getAutoMobileExpenses())
					{
						String AutomobileDate = sdf.format( au.getDate());
%>
	
	<tr>
	
	<td><%= AutomobileDate %></td>
	<td><%= au.getDescription() %></td>
	<td><%= au.getAmount() %></td>
	</tr>
	
<%
					}
			}
		}
%>   
		</table>	
		</div>
                    	</form>
                          
                          </section>
                         </div>
                        </div>
                        </div>
            

            
            
            
            
            
            </section>
       </section>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer class="site-footer">
          <div class="text-center">
              2015 - BPA Technologies
              
          </div>
      </footer>


</section>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../jquery.js"></script>
    <script src="../js/jquery-1.8.3.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../js/jquery.scrollTo.min.js"></script>
    <script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="../js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="../js/common-scripts.js"></script>
    
    <script type="text/javascript" src="../js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="../js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="../js/sparkline-chart.js"></script>    
	<script src="../js/zabuto_calendar.js"></script>	
	<!-- 
	<script type="text/javascript">
        $(document).ready(function () {
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'Welcome to Intranet!',
            // (string | mandatory) the text inside the notification
            text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
            // (string | optional) the image to display on the left
            image: '../img/ui-sam.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false;
        });
	</script>
	 -->
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        function saveall()
        {
        	alert("stupid");
        	window.href="../reimbursement/saveAllReimbursement.action";
        }
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  <script language="JavaScript">
		function showMeOutstation(box) {

			var chboxs = document.getElementsByName("outstation");

			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
			document.getElementById('outstationtable').style.display = vis;

		}

		function showMeEntertainment(box) {

			var chboxs = document.getElementsByName("entertainment");

			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
			document.getElementById('entertainmenttable').style.display = vis;
			
		}

		function showMeMisc(box) {

			var chboxs = document.getElementsByName("misc");

			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
			document.getElementById('misctable').style.display = vis;
			
		}

		function showMe(box) {

			var chboxs = document.getElementsByName("auto");
			var vis = "none";
			for (var i = 0; i < chboxs.length; i++) {
				if (chboxs[i].checked) {
					vis = "block";
					break;
				}
			}
			document.getElementById(box).style.display = vis;
			document.getElementById('automobiletable').style.display = vis;
			

		}
		function UncheckAll(){ 
		      var w = document.getElementsByTagName('input'); 
		      for(var i = 0; i < w.length; i++){ 
		        if(w[i].type=='checkbox'){ 
		          w[i].checked = false; 
		        }
		      }
		  }
	</script>
	
	<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"travel_on",
			dateFormat:"%Y-%M-%d"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
		new JsDatePick({
			useMode:2,
			target:"ent_date",
			dateFormat:"%Y-%M-%d"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
		new JsDatePick({
			useMode:2,
			target:"auto_date",
			dateFormat:"%Y-%M-%d"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
		new JsDatePick({
			useMode:2,
			target:"misc_date",
			dateFormat:"%Y-%M-%d"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
		
	};
	</script>

  </body>
</html>
