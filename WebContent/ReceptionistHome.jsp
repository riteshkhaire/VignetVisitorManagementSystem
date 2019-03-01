
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receptionist Home</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="vignet.com.bean.VisitorDetailBean"%>
	<%@page import="vignet.com.service.GenerateReport"%>
	<%@page import="java.util.Iterator"%>

	<form action="ReceptionistHome" method="post" align="center">
		<br>
		<h2>Vignet Visitor Management System</h2>
		<br> <br>

		<H3>Receptionist Home</h3>

		<input type="submit" value="Check In" name="checkInNewVisitor">
		&nbsp <input type="submit" value="Check Out" name="checkOut">
		&nbsp <input type="submit" value="Expected Visitor"
			name="expectedVisitor">&nbsp <input type="submit"
			value="Report" name="report"><br>
	</form>
	
</body>
</html>