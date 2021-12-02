<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Login::</title>
</head>

<body>
	<div class="container">
	<h1>Login</h1>
	<hr>
	<h2>Ingreso al sistema</h2>
	
		<form:form method="post" action="/login" modelAttribute="login">
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/>
			<br>
			<form:label path="password">Password:</form:label>
			<form:input type="text" path="password"/>
			<br>
			<input type="submit" value="Ingresar">
		</form:form>
		<li><a href="/registro">Sign In</a></li>
	</div>
</body>
</html>