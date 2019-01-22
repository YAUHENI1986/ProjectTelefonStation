<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>List all invoices</title>
</head>

<body>
	
	<h1>View All Invoices:</h1>
	<table border="1">
		<tr>
			<td><h3>Phone Number</h3></td>
			<td><h3>Invoice</h3></td>
			<td><h3>Status</h3></td>			
		</tr>
		
		<c:forEach items="${invoices}" var="invoices">
			<tr>
				<td>${invoices.getPhoneNumber()}</td>
				<td>${invoices.getInvoice()}</td>
				<td>${invoices.getStatus()}</td>
			</tr>			
		</c:forEach>
	</table>
	<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>	
	
</body>
</html>