<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="<c:url value="/style/button.css" />" />
<title>Online_Agenda</title>
</head>
<body style="height: 333px; ">



	<DIV ALIGN="center"><h1>Calendar</h1></DIV>
	<DIV ALIGN="center"><h2>${month}	${year}</h2></DIV>
	<DIV ALIGN="center"><a href="<c:url value="/calendar/previousmonth"/>"  class="myButton" >Previous Month</a>
	<a href="<c:url value="/calendar/nextmonth"/>"  class="myButton">Next Month</a></DIV>
	
	

	<table style="width: 700px; height: 600px; border-right-style: none; border-left-style: none; border-bottom-style: none; background-image: none; background-position: center center; border-top-style: none" align="center" cellspacing="10px" frame="border">
		<tr>
			<td height="30" width="100"><p align="center"><b><font color= "red" >Week</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Monday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Tuesday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Wednesday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Thursday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Friday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Saturday</font></b></p></td>
			<td height="30" width="100"><p align="center"><b><font color= "blue" >Sunday</font></b></p></td>
		</tr>

		<c:forEach items="${generateMonth}" var="week">
			<tr>
				<td height="30" width="100"><p align="center"><b><font color= "red" >${week.weekNumber}</font></b></p></td>
				<c:forEach items="${week.dagen}" var="dayOfWeeks">
					<td height="30" width="100"><p align="center"><b><font color= "blue" ><a href="<c:url value="/calendar/note"/>">${dayOfWeeks.day}</a></font></b></p></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>