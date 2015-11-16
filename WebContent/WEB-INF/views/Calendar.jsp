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
					<td height="30" width="100"><p align="center"><b><font color= "blue" >${dayOfWeeks.day}</font></b></p></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>