<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><spring:message code="menu.titulo"/></title>
	</head>
	<body>
		<div class="menu">
			<spring:message code="menu.titulo"/>
			<ul>
				<li>
					<spring:url value="/restaurantes" var="homeUrl" htmlEscape="true"/>
					<a href="${homeUrl}"><spring:message code="menu.restaurantes"/></a>
				</li>
				<li>
					<spring:url value="/reservar" var="bookingUrl" htmlEscape="true"/>
					<a href="${bookingUrl}"><spring:message code="menu.reservar" /></a>
				</li>
				<li>
					<spring:url value="/cancelar" var="cancelUrl" htmlEscape="true" />
					<a href="${cancelUrl}"><spring:message code="menu.cancelar" /></a>
				</li>
			</ul>
		</div>
		<div align="center">| <a href="?idioma=es">Castellano</a> | <a href="?idioma=en">English</a> |</div>
	</body>
</html>