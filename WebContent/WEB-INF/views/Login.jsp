<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<DIV ALIGN="center"><h1>Online Agenda</h1></DIV>


	<DIV ALIGN="center"><form><h4>Username<input></h4></form></DIV>
	<DIV ALIGN="center"><form><h4>Password<input></h4></form></DIV>

<DIV ALIGN="center"><a href="<c:url value="/register"/>"><h4>Register new user</h4></a></DIV>

</body>
</html>