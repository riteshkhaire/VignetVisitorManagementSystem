<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check In Walk-in Visitors</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="CheckIn" method="post" onsubmit="return validateForm()" align="center" name="checkIn">
		<br>
		<h2>
		 <a href="/VisitorManagementSystem/ReceptionistHome.jsp"> Vignet Visitor Management System</a> 
		 </h2>
		<br> <br> <h3> Add Visitor Details</h3> <br> 
		<a href="/VisitorManagementSystem/ReceptionistHome.jsp">
<img src="images/home.png" alt="Home" width="42" height="42" border="0">
</a> <br>
		<input type="text" placeholder="Visitor Name" name="visitorName" required maxLength="32" pattern="[A-Za-Z]{1,15}[\s][A-Za-Z]{1,15}"><br>
		<input type="email" placeholder="Visitor Email ID" name="visitorEmailId" required pattern="[a-zA-Z][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"><br> 
		<input type="text"placeholder="Visitor Mobile Number" name="visitorMobileNumber" required pattern="[789][0-9]{9}" tital="Enter valid Mobile Number"><br> 
		<input type="text" placeholder="Contact Person" name="contactPerson" required maxLength="32" pattern="[A-Za-Z]{1,15}[\s][A-Za-Z]{1,15}"><br> 	
		<input type="text" placeholder="Purpose" name="purpose" required><br>
		<input type="text"placeholder="Enter Adhar Number" name="idProof" required pattern="[1-9][0-9]{11}"><br>

		<input type="submit" value="Check-In" name="checkIn"><br>


	</form>
</body>
</html>