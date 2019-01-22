<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>Index</title>
	</head>

	<body>
	
	<form action="controller" method="POST">
		
		Entry as Administrator:
		<input type="hidden" name="command" value="admin_entry"/>
		<input type="submit" value="Entry"/>
				
	</form>
	<form action="controller" method="POST">
	
		Entry as User:
		<input type="hidden" name="command" value="user_entry"/>
		<input type="submit" value="Entry"/>
		
	</form>
	</body>
</html>