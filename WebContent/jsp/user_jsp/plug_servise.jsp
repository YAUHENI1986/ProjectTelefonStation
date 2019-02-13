<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Available list of tariffs</h1>
		<table border="1">
		<tr>
			<td><h3>№</h3></td>
			<td><h3>Type</h3></td>
			<td><h3>Description</h3></td>
			<td><h3>Cost Per Month</h3></td>
		</tr>
		<c:forEach items="${phoneServices}" var="phoneServices">
			<tr>
				<td>${phoneServices.getId()}</td>
				<td>${phoneServices.getType()}</td>
				<td>${phoneServices.getDescriprion()}</td>
				<td>${phoneServices.getCostPerMonth()}</td>
			</tr>
			
		</c:forEach>			
	</table>
	<h1>Input number service</h1>
	<form name="addPlug" action="controller" method="POST">
		<input type="hidden" name="command" value="add_plug"/>
		
		<input type="text" name="id_plug" placeholder="id plug"/>
		<input type="text" name="phone_number" placeholder="phone number"/>
		<input type="submit" value="Entry"/>
			<br/>
			${errorDoubleTariff}
			${errorCopyService}
			${serviceSuccessfullyAdded}
			${errorDataMessage}
			${errorIdMessage}
			${errorPhoneNumberMessage}
			<br/>				
	</form>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>
	</body>

</body>
</html>