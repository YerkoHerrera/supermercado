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
    <title>Venta::</title>
</head>

<body>
<jsp:include page="templates/navbar.jsp"/>
	<div class="container-fluid">
		<form:form method="post" action="/venta/login" modelAttribute="venta">
			<form:label path="codVenta">Codigo Venta:</form:label>
			<form:input type="text" path="codVenta"/>
			<br>
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="fecha">Fecha:</form:label>
			<form:input type="text" path="fecha"/>
			<br>
			<input type="button" value="Limpiar">
			<input type="submit" value="Submit">

		</form:form>
		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Codigo Venta</th>
					<th scope="col">Nombre</th>
					<th scope="col">Fecha</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaVentas}" var="venta">
					<tr>
						<th scope="row">${venta.getId()}</th>
						<td>${venta.getCodVenta()}</td>
                        <td>${venta.getNombre()}</td>
                        <td>${venta.getFecha()}</td>

                        <td>
                        	<a href="/venta/${venta.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
                        </td>
                        <td>
                        	<form action="/venta/eliminar" method="get">
                        		<input type="hidden" name="id" value="${venta.getId()}">
                        		<input type="submit" value="Eliminar">
                        	</form>
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>