<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title><spring:message code="reservado.titulo"/></title>
	</head>
	<body>
		<div class="body">
			<div class="alert alert-block alert-success">
				<spring:message code="reservado.titulo"/> ${localizador}
			</div>
		</div>
		<p>
			<a href="${pageContext.request.contextPath}/"><spring:message code="menu.volver"/></a>
		</p>
	</body>
</html>