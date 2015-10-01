<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="saveDepartment.action" name="myForm">
<table border=0 style="width:100%" >
	<tr bgcolor="#C7A395">
	<td><img src="bpa.png" style="height:100; width:100"></td>
	
</tr>
</table>
<br><br><br><br>
<table border=1 style="width:15%" align="center">

<tr>
	<td><b>Department Name</b></td><td><input type="text" name="departmentName"></td>
</tr>
<tr>
	<td><b>Department Description</b></td><td><input type="text" name="departmentDescription"></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" name="submit" value="submit"></td>
</tr>
</table>
</form>

</body>
</html>