<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expected Visitor</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="vignet.com.bean.VisitorDetailBean"%>
	<%@page import="vignet.com.service.GenerateReport"%>
	<%@page import="java.util.Iterator"%>

	<form action="ReceptionistHome" method="post" align="center">
		<br>
		<h2>
			<a href="/VisitorManagementSystem/ReceptionistHome.jsp">Vignet Visitor
				Management System</a>
		</h2>
		<br> <br>

		<H3>Expected Visitors</h3>
		<br>
			 		<a href="/VisitorManagementSystem/ReceptionistHome.jsp">
<img src="images/home.png" alt="Home" width="42" height="42" border="0">
</a><br> <br> <br>
		<%
			ArrayList<VisitorDetailBean> visitorList = (ArrayList) request.getAttribute("visitorList");
		%>

		<table cellspacing="2" cellpadding="2" align="center">
			<tr>
				<th>Visitor Id</th>
				<th>Visitor Name</th>
				
				<th>Status</th>
				<th>Email Id</th>
				<th>Expected Date</th>
			</tr>
			<%
				if (request.getAttribute("visitorList") != null) {
					Iterator<VisitorDetailBean> iterator = visitorList.iterator();
					while (iterator.hasNext()) {
						VisitorDetailBean visitorDetail = iterator.next();
						System.out.println("from jsp: "+visitorDetail.getPurpose());
			%>
			<tr>
				<td><%=visitorDetail.getVisitorID()%></td>
				<td><%=visitorDetail.getVisitorName()%></td>
				
				<td><%=visitorDetail.getStatus()%></td>
				<td><%=visitorDetail.getEmailId()%></td>
				<td><%=visitorDetail.getDate()%></td>


			</tr>
			<%
				}
				}
			%>

		</table>

	</form>
	<br>
	<form action="ReceptionistHome" method="post" align="center">
	 <input type="text" placeholder='Visitor ID' name="visitorID" > &nbsp <input type="submit" value="CheckIn" name="checkIn"><br> <br>
	</form>

</body>
</html>