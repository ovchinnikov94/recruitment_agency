<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1>${man.name} ${man.surname}</h1>
</div>
<div class="row">
<table class="table">
	<tr>
		<td><spring:message code="label.age"/></td>
		<td>${man.age}</td>
	</tr>
	<tr>
		<td><spring:message code="label.salary"/></td>
		<td>${man.salary}</td>
	</tr>
	<tr>
		<td><spring:message code="label.post"/></td>
		<td> ${man.post.postname}</td>
	</tr>
	<tr>
		<td><spring:message code="label.sphere"/></td>
		<td> ${man.sphere.spherename}</td>
	</tr>
	<tr>
		<td><spring:message code="label.edutype"/></td>
		<td> ${man.type.typename}</td>
	</tr>
	<tr>
		<td><spring:message code="label.spec"/></td>
		<td> ${man.spec.specname}</td>
	</tr>
	<c:if test="${!empty man.langs}">
		<tr>
			<td><spring:message code="label.langs" /></td>
			<td><c:forEach items="${man.langs}" var="l">${l.langname}<br></c:forEach></td>
		</tr>
	</c:if>
	<c:if test="${!empty man.skills}">
		<tr>
			<td><spring:message code="label.skills" /></td>
			<td><c:forEach items="${man.skills}" var="l">${l.skillname}<br></c:forEach></td>
		</tr>
	</c:if>
	<tr>
		<td>
			<a href="editPeople${man.idpeople}.do">
				<button type="button" class="btn btn-lg btn-primary"><spring:message code="label.edit" /></button>
			</a>
		</td>
		<td>
			<a href="deleteMan${man.idpeople}.do">
				<button type="button" class="btn btn-lg btn-danger"><spring:message code="label.delete" /></button>
			</a>
		</td>
		<td>
			<a href="showHist${man.idpeople}.do">
				<button type="button" class="btn btn-lg btn-info"><spring:message code="label.show_hist" /></button>
			</a>
		</td>
		<td>
			<a href="vacanciesByPeople${man.idpeople}.do">
				<button type="button" class="btn btn-lg btn-primary"><spring:message code="label.find_vacancy" /></button>
			</a>
		</td>
	</tr>
</table>
</div>