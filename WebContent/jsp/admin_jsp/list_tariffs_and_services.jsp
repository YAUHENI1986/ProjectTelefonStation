<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>List All</title>
</head>

<body>
	<h1>View All Phone Services:</h1>
	<table border="1">
		<tr>
			<td><h3>Id</h3></td>
			<td><h3>Status</h3></td>
			<td><h3>Type</h3></td>
			<td><h3>Description</h3></td>
			<td><h3>Cost Per Month</h3></td>
		</tr>
			
		<c:forEach items="${phoneServices}" var="phoneServices">
			<tr>
				<td>${phoneServices.getId()}</td>
				<td>${phoneServices.getStatus()}</td>
				<td>${phoneServices.getType()}</td>
				<td>${phoneServices.getDescriprion()}</td>
				<td>${phoneServices.getCostPerMonth()}</td>
			</tr>			
		</c:forEach>			
	</table>
	<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>
</body>

</html>