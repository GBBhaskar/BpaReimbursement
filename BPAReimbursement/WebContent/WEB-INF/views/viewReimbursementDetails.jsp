<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.io.*,com.bpaMiniProject.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Reimbursement</span>
                      </a>
                      <ul class="sub">
                         <li class="active"><a  href="viewReimbursementList.action">My Reimbursements</a></li>
                           <li><a  href="addReimbursement.action">Add Reimbursement</a></li>
                          <li><a  href="viewReimbursementApprovalList.action">Approvals</a></li>
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
	Reimbursement reimbursement = (Reimbursement)request.getAttribute("reimbursement");
	Integer managerId = (Integer)session.getAttribute("managerId");
	
	String approverComments = "";
	if (reimbursement.getApproverComments() != null)
	{
		approverComments = reimbursement.getApproverComments();
	}
	
	
%>
     
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i>Reimbursements</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> Reimbursement Details </h4>
                      
                          <section id="unseen">
                          





<table class="table table-bordered table-striped table-condensed">
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		String reimbursementDate = sdf.format(reimbursement.getDate());
	%>
	<tr>
		<td>Reference No:</td><td><%= reimbursement.getReimbursementCode() %></td>
		<td>Applied On</td><td><%= reimbursementDate %></td>
	</tr>

	<tr>
		<td>Status</td><td><%= reimbursement.getStatus() %></td>
		<td>SupplementaryInformation</td><td><%= reimbursement.getSupplementaryInformation() %></td>
	</tr>

	<tr>
		<td>Total Amount</td><td><%= reimbursement.getTotalExpense() %></td>
		<td>Amount Paid</td><td><%= reimbursement.getAdvanceAmount() %></td>
	</tr>

	<tr>
		<td>Due Amount</td><td><%= reimbursement.getDueAmount() %></td>
		<td>Purpose of Travel</td><td><%= reimbursement.getPurposeOfTravel() %></td>
	</tr>

</table> 


<h5>Automobile Expenses</h5>
           

<table class="table table-bordered table-striped table-condensed">
	<tr>
    	<td>Date</td><td>Description</td><td>Amount</td>
	</tr>
<%
	System.out.println("JSP problem:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+reimbursement.getAutoMobileExpenses().size());
	if (reimbursement.getAutoMobileExpenses().size() != 0)
	{
		for(AutomobileExpense autoExpense:reimbursement.getAutoMobileExpenses())
		{
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-YYYY");
			String autoExpenseDate = sdf1.format(autoExpense.getDate());
%>
	<tr>
		<td><%= autoExpenseDate %></td>
		<td><%= autoExpense.getDescription() %></td>
		<td><%= autoExpense.getAmount() %></td>
	</tr>	
<%
		}
	}
%>   
</table>
	

<h5>Entertainment Expenses</h5>
           

<table class="table table-bordered table-striped table-condensed">
	<tr>
		<td>Date</td>
		<td>Description</td>
		<td>Amount</td>
		<td>Purpose</td>
	</tr>
<%
	if (reimbursement.getEntertainmentExpenses().size() != 0)
    {
		for(EntertainmentExpense enterExpense:reimbursement.getEntertainmentExpenses())
		{
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-YYYY");
			String enterExpenseDate = sdf2.format(enterExpense.getDate());
%>
	<tr>
		<td><%= enterExpenseDate%></td>
		<td><%= enterExpense.getDescription()%></td>
		<td><%= enterExpense.getAmount() %></td>
		<td><%= enterExpense.getNotes()%></td>
	</tr>
<%
		}
	}
%>
</table>


<h5>Misc Expenses</h5>
           

<table class="table table-bordered table-striped table-condensed">
	<tr>
		<td>Date</td>
		<td>Description</td>
		<td>Amount</td>
	</tr>
<%
	if (reimbursement.getMiscellaneousExpenses().size() != 0)
    {
		for(MiscellaneousExpense missExpense:reimbursement.getMiscellaneousExpenses())
		{
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-YYYY");
			String miscDate = sdf3.format(missExpense.getDate());
%>
	<tr>
		<td><%=miscDate%></td>
		<td><%=missExpense.getDescription() %></td>
		<td><%=missExpense.getAmount()%></td>
	</tr>
<%
		}
    }
%>
</table>

            
           
<h5>OutStation Expenses</h5>
           

                <table class="table table-bordered table-striped table-condensed">
                   <tr>
	<td>Date</td><td>State</td><td>Description</td><td>Room Rent</td>
	<td>Car Rent</td><td>AutoMobile Expense</td><td>BreakFast Expense</td><td>Lunch Expense</td>
	<td>Dinner Expense</td><td>Entertainment Expense</td><td>Miscellaneous Expense</td><td>Daily Total</td>
</tr>
      <%
      if (reimbursement.getOutStationExpenses().size() != 0)
      {
		for(OutStationExpense outExpense:reimbursement.getOutStationExpenses())
		{
			SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-YYYY");
			String outExpenseDate = sdf4.format(outExpense.getDate());
%>
	<tr>
	<td><%=outExpenseDate %></td>
	<td><%=outExpense.getState() %></td>
	<td><%=outExpense.getDescription() %></td>
	<td><%=outExpense.getRoomRent() %></td>
	<td><%=outExpense.getCarRental()%></td>
	<td><%=outExpense.getAutomobileExpense() %></td>
	<td><%=outExpense.getBreakfastExpense()%></td>
	<td><%=outExpense.getLunchExpense()%></td>
	<td><%=outExpense.getDinnerExpense() %></td>
	<td><%=outExpense.getEntertainmentExpense() %></td>
	<td><%=outExpense.getMiscellaneousExpense() %></td>
	<td><%=outExpense.getDailyTotal() %></td>
	</tr>
<%
		}
      }
%>
         </table>


<h5>Approval Section</h5>
<form method="post" name="managerform" action="../reimbursement/approveReimbursement.action">
<table class="table table-bordered table-striped table-condensed">
<c:if test="${managerId == 0}">
<tr>
	<td>Is Approved ?</td>
	<td colspan="3">
		<input type="radio" name="approve_status" value="A" checked>Approved
		&nbsp;&nbsp;<input type="radio" name="approve_status" value="R" >Rejected
	</td>
</tr>
</c:if>
<c:choose>
    <c:when test="${managerId == 0}">
       <tr>
	<td>Approver Comments</td>
	<td colspan="3">
		<textarea rows="4" cols="135" 	name="approver_comments"><%= approverComments %></textarea>
	</td>
</tr>

<tr>
<td colspan="4" align="center">
	<input type="hidden" name="reimbursementId" value="<%= reimbursement.getReimbursementId() %>">
	
	 <input type="submit" name="Save" value="Submit" class="btn btn-primary">
</tr>
    </c:when>
    
    <c:otherwise>
       <tr>
	<td>Approver Comments</td>
	<td colspan="3">
		<textarea rows="4" readonly cols="135" 	name="approver_comments"><%= approverComments %></textarea>
	</td>
</tr>

    </c:otherwise>
</c:choose>
<c:if test="${managerId == 0}">

</c:if>
</table>
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
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>
