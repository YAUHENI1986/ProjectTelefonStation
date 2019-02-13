<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add service</title>
</head>
<body>

<h1>Add service:</h1>
		<hr/>
		${user}, hello!
		<hr/>

<form name="addServ" action="controller" method="POST">

	<input type="hidden" name="command" value="get_balance_services"/>

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
		
	<input type="submit" value="get balance/services"/>
</form>

<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>

</body>
</html>