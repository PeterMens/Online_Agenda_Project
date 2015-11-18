<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<DIV ALIGN="center"><h1> Register New User </h1></DIV>

<form:form id="registerform" method="POST" modelAttribute="user">

<DIV ALIGN="center"><TABLE>
	<TBODY>
		<TR>
			<TD><DIV ALIGN="center"><h4>User Name</h4></DIV></TD>
			<TD><input name="username"> </TD>
		</TR>
		<TR>
			<TD><DIV ALIGN="center"><h4>New Password</h4></DIV></TD>
			<TD><input name="newPassword"></TD>
		</TR>
		<TR>
			<TD><DIV ALIGN="center"><h4>Confirm Password</h4></DIV></TD>
			<TD><input name="confirmPassword"></TD>
		<TR>
</TABLE></DIV>	

<DIV ALIGN="center"><input type="submit" value="Submit"></DIV>

</form:form>
	
</body>
</html>