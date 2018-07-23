<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="body">
	<div class="alert alert-block alert-success">
		<c:choose>
			<c:when test="${estado}">
				<spring:message code="cancelada.titulo" />
				<br />
				<spring:message code="cancelada.localizador" /> ${localizador}<br />
			</c:when>
			<c:otherwise>
				<spring:message code="cancelada.localizador.incorrecto" /><br/>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${estado}">
				<spring:message code="cancelada.dia" /> ${dia}</c:when>
			<c:otherwise><spring:message code="cancelada.dia.incorrecto"/> ${dia}<br /></c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${estado}">
				<spring:message code="cancelada.personas" /> ${personas}<br/></c:when>
			<c:otherwise><spring:message code="cancelada.personas.incorrecto"/> ${personas}<br/></c:otherwise>
		</c:choose>

	</div>
	<p>
		<a href="${pageContext.request.contextPath}/">
			<spring:message code="menu.volver" />
		</a>
	</p>
</div>