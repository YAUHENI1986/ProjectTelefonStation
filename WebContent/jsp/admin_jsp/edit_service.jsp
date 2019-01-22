<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit service:</h1>

<form name="editServ" action="controller" method="POST">

	<input type="hidden" name="command" value="edit_service"/>
	
	<input type="text" name="id" placeholder="id"/>
	<select name="type_list">
		<option>choose of type</option>
		<option value="tariff">tariff</option>
		<option value="service">service</option>
	</select>
	<select name="status_list">
		<option>choose of status</option>
		<option value="closed">closed</option>
		<option value="active">active</option>
		<option value="in_developing">in developing</option>
	</select>	
	<input type="text" name="description" placeholder="description"/>
	<input type="text" name="cost_per_month" placeholder="cost per month"/>
	
	<br/>
			${errorDataMessage}
	<br/>
	<br/>
			${errorConsilienceService}
	<br/>
		
	<input type="submit" value="edit service"/>
</form>
<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>


</body>
</html>