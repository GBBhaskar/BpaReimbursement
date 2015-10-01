<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <meta charset="utf-8">
    <title>:: BPA Technologies ::</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
   

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
   	 
   
    <link href='css/animate.min.css' rel='stylesheet'>

    <script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/jquery-migrate-1.2.1.min.js"></script>
	<script src="js/jquery-ui-1.10.3.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/modernizr.min.js"></script>
	<script src="js/jquery.cookies.js"></script>

	<script src="js/custom.js"></script>

 	<script type="text/javascript">
	function validateform()
	{
	
		var name=document.myForm.userEmail.value;
		var password=document.myForm.password.value;
		atpos=name.indexOf("@");
		dotpos=name.lastIndexOf(".");
		
			if(name==null||name.length <= 0)		
			{
				alert("email cant be blank");
				document.myForm.userEmail.focus();
				return false;
			}
		   
				
				if(atpos <1 || (dotpos-atpos <2))
			{
				alert("please enter the valid email");
				document.myForm.userEmail.focus();
				return false;
			}
				
			
			if(password.length<6)
			{ 
				alert("password minimum length should be six");
				document.myForm.password.focus();
				return false;
			}
				return true;
	}
	
	
</script>    		

</head>

<body>

<center><img src="img/bpa_logo.png" style="margin-top:30px"></center>
<div class="ch-container">
    <div class="row">
    
    
    
    
    <div class="row">
        <div class="col-md-12 center login-headermessage">
        	<h2>Welcome to BPA TECHNOLOGIES</h2>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Please login with your Username and Password.
            </div>
           <form method="post" action="loginVerification.action" name="myForm" onsubmit= "return validateform()">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" class="form-control" placeholder="Email" id = "userEmail" name="userEmail">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" class="form-control" placeholder="Password" name="password">
                    </div>
                    <div class="clearfix"></div>

                    <div class="input-prepend">
                        <label class="remember" for="remember"><input type="checkbox" id="remember"> Remember me</label>
                    </div>
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->




</body>
</html>
