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
<title><spring:message code="cancelar.titulo"/></title>
<div class="body">
	<form:form action="cancelado" method="post">
		<div>
			<label for="restaurante"><spring:message code="cancelar.restaurante"/></label>
			<form:select path="restauranteId" items="${command.restaurantes}"
				itemValue="id" itemLabel="nombre" htmlEscape="true" />
		</div>

		<div>
			<label for="dia"><spring:message code="cancelar.dia"/></label>
			<form:input path="dia" type="text" cssClass="date-picker" />
		</div>

		<div>
			<label for="turno"><spring:message code="cancelar.turno"/></label>
			<form:select path="turnoId" items="${command.turnos}" itemValue="id"
				itemLabel="descripcion" htmlEscape="true" />
		</div>

		<div>
			<label for="localizador"><spring:message code="cancelar.localizador"/></label>
			<form:input path="localizador" type="text"/>
		</div>
		<div>
			<button type="submit" value="Cancelar"><spring:message code="cancelar.submit"/></button>
		</div>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/"><spring:message code="menu.volver"/></a>
	</p>
</div>