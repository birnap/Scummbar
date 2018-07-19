<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.7.3/themes/base/jquery-ui.css">
<script>
	$(function() {
		$('#dia').datepicker({
			dateFormat : 'mm/dd/yy'
		});
		$('#dia').attr('readonly', true);
	});
</script>
<html>
	<title><spring:message code="reserva.titulo"/></title>
	<h2><spring:message code="reserva.titulo"/></h2>
	<div class="body">
		<form:form action="reservado" method="post">
			<div>
				<label for="restaurante"><spring:message code="reserva.restaurante"/></label>
				<form:select path="restauranteId" items="${command.restaurantes}"
					itemValue="id" itemLabel="nombre" htmlEscape="true" />
			</div>
	
			<div>
				<label for="dia"><spring:message code="reservar.dia"/></label>
				<form:input path="dia" type="text" cssClass="date-picker" />
			</div>
	
			<div>
				<label for="turno"><spring:message code="reservar.turno"/></label>
				<form:select path="turnoId" items="${command.turnos}" itemValue="id"
					itemLabel="descripcion" htmlEscape="true" />
			</div>
	
			<div>
				<label for="personas"><spring:message code="reservar.personas"/></label>
				<form:select path="personas" htmlEscape="true">
					<c:forEach begin="1" end="10" var="count">
						<form:option value="${count}" />
					</c:forEach>
				</form:select>
			</div>
			<div>
				<button type="submit" value="Reservar"><spring:message code="reservar.submit"/></button>
			</div>
		</form:form>
		<p>
			<a href="${pageContext.request.contextPath}/"><spring:message code="menu.volver"/></a>
		</p>
	</div>
</html>