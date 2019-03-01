<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form name="SignUp" action="SignUp" method="post" align="center" onsubmit="return validateForm()">
		<br>
		<h2>Vignet Visitor Management System</h2>
		<br> <br> <br>
		<h3>Sign Up</h3>
		<br>
		<input type="text" placeholder="Enter Name" name="newName" required maxLength="32" pattern="[A-Za-Z]{1,15}[\s][A-Za-Z]{1,15}"><br>
		<input type="text" placeholder="Mobile Number" name="newUserMobile" required pattern="[789][0-9]{9}" tital="Enter valid Mobile Number"><br>
		<input type="email" placeholder="username@domain.com" name="newUserName" required pattern="[a-zA-Z][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"><br>
		<input type="password" placeholder="Choose Password" name="newUserPassword" required><br>
		<input type="password" placeholder="Re-Enter Password" name="newUserRePassword" required><br>
		
		
		<select name="role" id="dropdown" required>
                <option value="dropdown">Role</option>
                <option value="Receptionist">Receptionist</option>
                <option value="HR">HR</option>
                <option value="Admin">Admin</option>
            </select><br>
	 <input type="submit" value="Sign-up" name="newUserSignUp"><br>
		
		
		</form>

</body>
</html>