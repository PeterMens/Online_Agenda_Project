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

<form:form id="loginform" method="POST" modelAttribute="user">

<DIV ALIGN="center"><TABLE>
	<TBODY>
		<TR>
			<TD><DIV ALIGN="center"><h4>User Name</h4></DIV></TD>
			<TD><input name="usernameInput"> </TD>
		</TR>
		<TR>
			<TD><DIV ALIGN="center"><h4>Password</h4></DIV></TD>
			<TD><input type="password" name="passwordInput"></TD>
		</TR>
	
</TABLE></DIV>	
<TD><DIV ALIGN="center"><font color= "red" ><h4>${usernameEmpty}${passwordEmpty}${invalidUsername}${invalidPassword}</h4></font></DIV></TD>
<DIV ALIGN="center"><input type="submit" value="Log in"></DIV>
</form:form>

	
<DIV ALIGN="center"><a href="<c:url value="/register"/>"><h4>Register new user</h4></a></DIV>

</body>
</html>