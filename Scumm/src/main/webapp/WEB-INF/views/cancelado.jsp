<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Reserva cancelada</title>
	</head>
	<body>
		<div class="body">
			<div class="alert alert-block alert-success">
				Reserva cancelada ${cancelado}
			</div>
		</div>
		<p>
			<a href="${pageContext.request.contextPath}/hello">Home page</a>
		</p>
	</body>
</html>