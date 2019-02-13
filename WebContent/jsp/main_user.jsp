<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Welcome User</title>
	</head>

	<body>
		
		<h1>List of tariffs for today</h1>
		<table border="1">
		<tr>
			<td><h3>Type</h3></td>
			<td><h3>Description</h3></td>
			<td><h3>Cost Per Month</h3></td>
		</tr>
			
		<c:forEach items="${phoneServices}" var="phoneServices">
			<tr>
				<td>${phoneServices.getType()}</td>
				<td>${phoneServices.getDescriprion()}</td>
				<td>${phoneServices.getCostPerMonth()}</td>
			</tr>			
		</c:forEach>			
	</table>
	<br/>
	<a href="controller?command=jsp_plug_service">To plug service</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>
	</body>
</html>