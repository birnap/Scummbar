<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
Menu
	<ul>
		<li>
			<spring:url value="/restaurantes" var="homeUrl" htmlEscape="true"/>
			<a href="${homeUrl}">Restaurantes</a>
		</li>
		<li>
			<spring:url value="/reservar" var="bookingUrl" htmlEscape="true"/>
			<a href="${bookingUrl}">Realizar una reserva</a>
		</li>
		<li>
			<spring:url value="/cancelar" var="cancelUrl" htmlEscape="true"/>
			<a href="${cancelUrl}">Cancelar una reserva</a>
		</li>
	</ul>
</div>