<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controller" class="br.com.arkhi.test.arquillian.controller.CervejaController"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ABM (ARKHI Beer Manager)</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div style="margin-left: 20px; margin-top: 20px;">
		<c:if test="${param.warningMessage != null}">
		    <span class="label label-warning">${param.warningMessage}</span>
		</c:if>
		
		<c:if test="${param.errorMessage  != null}">
		    <span class="label label-important">${param.errorMessage}</span>
		</c:if>
		
		<c:if test="${param.successMessage  != null}">
		    <span class="label label-success">${param.successMessage}</span>
		</c:if>
		
		<form action="salvarCerveja" method="post">
			<legend>Cadastro de cerveja</legend>
			<table>
				<tr>
					<td></td>
					<td>
					</td>
				</tr>
				
				<tr>
					<td>Nome da Cerveja:</td>
					<td>
						<input type="text" name="nomeCerveja" /> 
					</td>
				</tr>
				<tr>
					<td>Malte:</td>
					<td>
						<select name="malte">			
							<c:forEach var="malte" items="${controller.maltes}">
							    <option value="${malte.id}" >${malte.nome}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Lúpulo:</td>
					<td>
						<select name="lupulo">			
							<c:forEach var="lupulo" items="${controller.lupulos}">
							    <option value="${lupulo.id}" >${lupulo.nome}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Levedo:</td>
					<td>
						<select name="levedo">			
							<c:forEach var="levedo" items="${controller.levedos}">
							    <option value="${levedo.id}" >${levedo.nome}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>	
			
			<br />	
			
			<button class="btn btn-primary" type="submit">Salvar</button>
		</form>
	</div>

</body>
</html>