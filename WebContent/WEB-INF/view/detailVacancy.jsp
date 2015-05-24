<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1>${vacancy.post.postname}, ${vacancy.salary}</h1>
</div>
<div class="row">
<table class="table">
	<tr>
		<td><spring:message code="label.sphere"/></td>
		<td>${vacancy.sphere.spherename}</td>
	</tr>
	<tr>
		<td><spring:message code="label.post"/></td>
		<td>${vacancy.post.postname}</td>
	</tr>
	<tr>
		<td><spring:message code="label.salary"/></td>
		<td>${vacancy.salary}</td>
	</tr>
	<tr>
		<td><spring:message code="label.edutype"/></td>
		<td>${vacancy.type.typename}</td>
	</tr>
	<tr>
		<td><spring:message code="label.post"/></td>
		<td>${vacancy.post.postname}</td>
	</tr>
	<tr>
		<td><spring:message code="label.company"/></td>
		<td><a href="companies.do">${vacancy.company.name}</a></td>
	</tr>
	<tr>
		<td><spring:message code="label.spec"/></td>
		<td>${vacancy.spec.specname}</td>
	</tr>
	<c:if test="${!empty vacancy.skills}">
	<tr>
		<td><spring:message code="label.skills"/>:</td>
		<td><c:forEach items="${vacancy.skills}" var="s">${s.skillname}<br></c:forEach></td>
	</tr>
	</c:if>
	<c:if test="${!empty vacancy.langs}">
	<tr>
		<td><spring:message code="label.langs"/>:</td>
		<td><c:forEach items="${vacancy.langs}" var="l">${l.langname}<br></c:forEach></td>
	</tr>
	</c:if>
</table>
<table class="table">
	<tr>
		<td>
			<a href="editVacancy${vacancy.idvacancy}.do">
				<button type="button" class="btn btn-lg btn-primary"><spring:message code="label.edit"/></button>
			</a>
		</td>
		<td>
			<a href="deleteVacancy${vacancy.idvacancy}.do">
				<button type="button" class="btn btn-lg btn-danger"><spring:message code="label.delete"/></button>
			</a>
		</td>
		<td>
			<a href="peopleByVacancy${vacancy.idvacancy}.do">
				<button type="button" class="btn btn-lg btn-primary"><spring:message code="label.find_people"/></button>
			</a>
		</td>
	</tr>
</table>	
</div>