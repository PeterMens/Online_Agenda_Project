<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>note</title>
</head>
<body>

<DIV ALIGN="center"><h3>Add Note</h3>
<form:form id="Note" method="POST" modelAttribute="note">
<p><textarea rows="15" cols="50"></textarea></p>
<p><input type="submit" value="Submit Note"></p>
</form:form></DIV>
	
<DIV ALIGN="center"><h3>#### Display note here via Expression Language ${getNote} ####</h3></DIV>
 
<DIV ALIGN="center"><a href="<c:url value="/calendar"/>"><h4>Back to Agenda</h4></a></DIV>

</body>
</html>