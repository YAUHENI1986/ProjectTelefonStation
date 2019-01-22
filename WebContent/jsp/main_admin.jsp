<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Welcome Administrator</title>
	</head>

	<body>
		<h3>Welcome</h3>
		<hr/>
		${user}, hello!
		<hr/>
		
		<ul>
			<li><a href="controller?command=list_subscribers">view all subscribers</a></li>
			<li><a href="controller?command=jsp_add_subscriber">add subscriber</a></li>
		</ul><ul>
			<li><a href="controller?command=list_phone_services">view all phone services</a></li>
			<li><a href="controller?command=jsp_add_service">add service</a></li>
			<li><a href="controller?command=jsp_edit_service">edit service</a></li>
		</ul><ul>
			<li><a href="controller?command=list_invoices">view all invoices</a></li>
		</ul>
		
		<a href="controller?command=logout">Logout</a>
	</body>
</html>