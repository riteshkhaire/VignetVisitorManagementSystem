<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="login" method="post" align="center">
		<br>
		<h2>Vignet Visitor Management System</h2>
		<br> <br> <br>
		<input type="text" placeholder="User Name" name="userName"><br>
		<br>
		<input type="password" placeholder="Password" name="password"><br>
		<br>
		<input type="submit" value="Sign-in" name="signIn"> <input type="submit"
			value="Sign-up" name="signUp"><br>

	</form>
</body>
</html>