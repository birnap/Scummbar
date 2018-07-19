<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<head>
		<title><spring:message code="lista.restaurantes.titulo"/></title>
	</head>
		<h2><spring:message code="reserva.restaurante"/></h2>
		<table border="1px" cellpadding="0" cellspacing="0">
				<tr>
					<th width="10%"><spring:message code="lista.restaurantes.id"/></th>
					<th width="10%"><spring:message code="lista.restaurantes.nombre"/></th>
					<th width="15%"><spring:message code="lista.restaurantes.direccion"/></th>
					<th width="10%"><spring:message code="lista.restaurantes.descripcion"/></th>
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
		<p><a href="${pageContext.request.contextPath}/"><spring:message code="menu.volver"/></a></p>
