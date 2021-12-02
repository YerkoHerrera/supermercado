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
    <title>Carrito::</title>
</head>

<body>
<jsp:include page="templates/navbar.jsp"/>
	<div class="container-fluid">
		<h1>${nombre_usuario}</h1>
		<hr>
		<h2>Tu carrito</h2>		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Valor</th>
					<th scope="col">Nombre</th>
					<th scope="col">Descripcion</th>
					<th scope="col">Categoria</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaProductos}" var="carrito">
					<tr>
						<!-- Aqui se llama al carrito del usuario -->
						<th scope="row">${producto().getId()}</th>
						<td>${producto().getValorBase()}</td>
                        <td>${producto().getNombre()}</td>
                        <td>${producto().getDescripcion()}</td>
                        <td>${producto().getCategoria().getNombre()}</td>
                        <td>
                        	<form action="/carrito/eliminar" method="get">
                        		<input type="hidden" name="id" value="${carrito.productos().getId()}">
                        		<input type="submit" value="Eliminar">
                        	</form>
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<tr>
				<c items="${total}" var="carrito"></c>
			</tr>
	</div>
</body>

</html>