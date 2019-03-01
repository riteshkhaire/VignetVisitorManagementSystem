<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Expected Visitor</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="AddExpectedVisitor" method="post" onsubmit="return validateForm()" align="center" name="addExpectedVisitor">
		<br>
		<h2><a href="/VisitorManagementSystem/AdminHome.jsp">Vignet Visitor Management System</h2></a>
		<br> <br> <br> Add Expected Visitor Details <br> 
		
	<!--  	<input type="submit" value="Add Expected Visitor" name="addExpectedVisitors">
		<input type="submit" value="Report" name="report"><br>-->
		<input type="text" placeholder="Visitor Name" name="visitorName" required><br>
		<input type="text" placeholder="Visitor Email ID" name="visitorEmailId" required><br> 
		<input type="text"placeholder="Visitor Mobile Number" name="visitorMobileNumber" required><br> 
		<input type="date" placeholder="Expected Date to Visit" name="expectedVisitDate" required><br> 
		<input type="text"placeholder="Expected Time to Visit" name="expectedVisitTime" required><br>	
		<input type="text" placeholder="Purpose" name="purpose" required><br>

		<input type="submit" value="Add Details" name="addDetails"><br>


	</form>
</body>
</html>