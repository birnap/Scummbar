<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC -HelloWorld</title>
</head>
<body>
	<h1>Hello: ${name}</h1>
	<p><a href="${pageContext.request.contextPath}/restaurantes">Ver restaurantes</a></p>
	<p><a href="${pageContext.request.contextPath}/reservar">Hacer reserva</a></p>
	<p><a href="${pageContext.request.contextPath}/cancelar">Cancelar reserva</a></p>
</body>
</html>