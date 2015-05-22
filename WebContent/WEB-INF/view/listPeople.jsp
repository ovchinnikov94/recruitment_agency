<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-header">
<h1><spring:message code="label.people"/></h1>
</div>
<div class="row">
<a href="addMan.do"><button type="button" class="btn btn-lg btn-primary"><spring:message code="label.add_people"/></button></a>
<c:if test="${hasParametres}">
	<p><spring:message code="label.parametres"/>:</p>
	<table class="table">
		<c:if test="${(parametres.minSal>0 || parametres.maxSal>0) && parametres.minSal<parametres.maxSal}">
		<tr>
			<td><spring:message code="label.salary"/></td>
			<td>
				<spring:message code="label.from"/>
				${parametres.minSal}
				<spring:message code="label.to" />
				${parametres.maxSal}
			</td>
		</tr>
		</c:if>
		<tr>
			<td><spring:message code="label.langs"/>(${parametres.langs.size()}):</td>
			<td>
				<c:forEach items="${parametres.langs}" var="l">${l.langname},<br></c:forEach>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.skills"/>(${parametres.skills.size()}):</td>
			<td>
				<c:forEach items="${parametres.skills}" var="l">${l.skillname},<br></c:forEach>
			</td>
		</tr>
		<tr>
			<td>${parametres.searchQuery}</td>
		</tr>
	</table>
</c:if>

<c:if test="${!empty peopleList}">
<table class="table table-striped">
<thead>
<tr>
    <th><spring:message code="label.firstname"/>, <spring:message code="label.surname"/></th>
    <th><spring:message code="label.salary"/></th>
    <th>&nbsp;</th>
</tr>
</thead>
<tbody>
<c:forEach items="${peopleList}" var="p">
    <tr>
        <td><a href="showMan${p.idpeople}.do">${p.name} 
         ${p.surname} </a></td>
        <td>${p.salary}</td>
        <td>
        	<a href="deleteMan${p.idpeople}.do">
        		<button type="button" class="btn btn-danger"><spring:message code="label.delete"/></button>
        	</a>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>