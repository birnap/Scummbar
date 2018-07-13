<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Restaurantes</title>
	</head>
	<body>
		<h1>Restaurantes</h1>
		<table border="1px" cellpadding="0" cellspacing="0">
				<tr>
					<th width="10%">Id</th>
					<th width="10%">Nombre</th>
					<th width="15%">Direccion</th>
					<th width="10%">Descripcion</th>
				</tr>
			<tbody>
				<c:forEach var="restaurante" items="${listaRestaurantes}" >
					<tr>
						<td>${restaurante.id}</td>
						<td>${restaurante.nombre}</td>
						<td>${restaurante.direccion}</td>
						<td>${restaurante.descripcion}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="${pageContext.request.contextPath}/hello">Home page</a></p>
	</body>
</html>