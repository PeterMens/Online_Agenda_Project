<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online_Agenda</title>
</head>
<body style="height: 333px; ">

	<DIV ALIGN="center"><h1>Calendar</h1></DIV>
	<DIV ALIGN="center"><h2><form>	
			</form>${month}	${year}</h2></DIV>
	
	
	<table style="width: 700px; height: 600px; border-right-style: none; border-left-style: none; border-bottom-style: none; background-image: none; background-position: center center; border-top-style: none" align="center" cellspacing="10px" frame="border">
		<tr>
			<td height="30" width="100"><p align="center"><b>Week</b></p></td>
			<td height="30" width="100"><p align="center"><b>Monday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Tuesday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Wednesday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Thursday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Friday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Saturday</b></p></td>
			<td height="30" width="100"><p align="center"><b>Sunday</b></p></td>
		</tr>
		
		<c:forEach items="${generateMonth}" var="week">
			<tr>
				<td height="30" width="100"><p align="center"><b>${week.weekNumber}</b></p></td>
				<c:forEach items="${week.days}" var="dayOfWeeks">
					<td height="30" width="100"><p align="center"><b>${dayOfWeeks}</b></p></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>