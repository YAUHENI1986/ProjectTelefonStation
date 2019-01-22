<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Welcome User</title>
	</head>

	<body>
		<h3>Welcome</h3>
		
		<h3>List of tariffs for today</h3>
				
		<ul>
			<li><a href="TelefoneStationSevlet?action=list_subscribers">list subscribers</a></li>
			<li><a href="add_subscriber.jsp">add subscriber</a></li>
		</ul><ul>
			<li><a href="TelefoneStationSevlet?action=list_phone_services">view all phone services</a></li>
			<li><a href="add_service.jsp">add service</a></li>
			<li><a href="edit_service.jsp">edit service</a></li>
		</ul>
		
		<a href="controller?command=logout">Logout</a>
	</body>
</html>