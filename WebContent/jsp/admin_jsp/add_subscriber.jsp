<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Add subscriber</title>
</head>
<body>

<h1>Add subscriber:</h1>

<form name="addSub" action="controller" method="POST">

	<input type="hidden" name="command" value="add_subscriber"/>

	<input type="text" name="name" placeholder="name"/>
	<input type="text" name="surname" placeholder="surname"/>
	<input type="text" name="adress" placeholder="adress"/>
	<input type="text" name="personal_number_passport" placeholder="personal number passport"/>
			<br/>
			${errorDataMessage}
			<br/>
			${errorConsilienceSubscriber}
			<br/>
			${wrongAction}
			<br/>
			${nullPage}
			<br/>
	
	<input type="submit" value="add subscriber"/>
	
</form>	

<br/><br/>		
	<a href="controller?command=main_admin">Back to menu administrator</a>
	<br/>
	<a href="controller?command=logout">Exit to main menu</a>

</body>
</html>