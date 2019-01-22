<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>List All</title>
</head>

<body>
	<h1>View All Subscribers:</h1>
	<table border="1">
		<tr>
			<td><h3>Id</h3></td>
			<td><h3>Name</h3></td>
			<td><h3>Surname</h3></td>
			<td><h3>Address</h3></td>
			<td><h3>Personal № Passport</h3></td>
		</tr>
		
		<c:forEach items="${subscribers}" var="subscribers">
			<tr>
				<td>${subscribers.getUniqueNumber()}</td>
				<td>${subscribers.getName()}</td>
				<td>${subscribers.getSurname()}</td>
				<td>${subscribers.getAdress()}</td>
				<td>${subscribers.getPersonalNumberPassport()}</td>
			</tr>			
		</c:forEach>
	</table>
	<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>
</body>

</html>