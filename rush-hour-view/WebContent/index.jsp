<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="entitiesCache" class="br.com.arkhi.test.arquillian.cache.EntitiesCache"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ABM (ARKHI Beer Manager)</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div style="margin-left: 20px; margin-top: 20px;">
			
		<form action="saveBeer" method="post">
			<legend>Cadastro de cerveja</legend>
			
			<c:choose>
				<c:when test="${param.warningMessage != null}"><span class="label label-warning">${param.warningMessage}<br /><br /></span></c:when>
				<c:when test="${param.errorMessage != null}"><span class="label label-important">${param.errorMessage}<br /><br /></span></c:when>
				<c:when test="${param.successMessage != null}"><span class="label label-success">${param.successMessage}<br /><br /></span></c:when>
			</c:choose>
			
			<table>
								
				<tr>
					<td>* Nome da Cerveja:</td>
					<td>
						<input type="text" name="beerName" /> 
					</td>
				</tr>
				<tr>
					<td>* Malte:</td>
					<td>
						<select name="malt">			
							<c:forEach var="malt" items="${entitiesCache.malts}">
							    <option value="${malt.id}" >${malt.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>* Lúpulo:</td>
					<td>
						<select name="hop">			
							<c:forEach var="hop" items="${entitiesCache.hops}">
							    <option value="${hop.id}" >${hop.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>* Levedo:</td>
					<td>
						<select name="yeast">			
							<c:forEach var="yeast" items="${entitiesCache.yeasts}">
							    <option value="${yeast.id}" >${yeast.name}</option>
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