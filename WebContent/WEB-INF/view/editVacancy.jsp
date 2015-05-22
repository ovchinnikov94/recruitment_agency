<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-header">
<h1>
	<c:choose>
    <c:when test="${action.equals(\"saveMan.do\")}">
    	<spring:message code="label.add_vacancy"/>
    </c:when>
    <c:when test="${action.equals(\"saveUpdateMan.do\")}">
    	<spring:message code="label.edit_vacancy"/>
    </c:when>
    <c:otherwise>
    	<spring:message code="label.edit_vacancy"/>
    </c:otherwise>              
</c:choose>
</h1>
</div>
<div class="row">
	<form:form commandName="vacancy" method="post" action="${action}">
		<table class="table table-striped">
		<tr>
			<td><form:label path="salary"><spring:message code="label.salary"/></form:label></td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td><form:label path="company"><spring:message code="label.company"/></form:label></td>
			<td><form:select path="company.idcompany" items="${companyList}" itemValue="idcompany" itemLabel="name" /></td>
		</tr>
		<tr>
			<td><form:label path="sphere"><spring:message code="label.sphere"/></form:label></td>
			<td><form:select path="sphere.idsphere" items="${sphereList}" itemValue="idsphere" itemLabel="spherename" /></td>
		</tr>
		<tr>
			<td><form:label path="post"><spring:message code="label.post"/></form:label></td>
			<td><form:select path="post.idpost" items="${postList}" itemValue="idpost" itemLabel="postname" /></td>
		</tr>
		<tr>
			<td><form:label path="type"><spring:message code="label.edutype"/></form:label></td>
			<td><form:select path="type.idtype" items="${typeList}" itemValue="idtype" itemLabel="typename" /></td>
		</tr>
		<tr>
			<td><form:label path="spec"><spring:message code="label.spec"/></form:label></td>
			<td><form:select path="spec.idspec" items="${specList}" itemValue="idspec" itemLabel="specname" /></td>
		</tr>
		<tr>
			<td><form:label path="langs"><spring:message code="label.langs"/>:</form:label></td>
			<td>
				<fieldset>
				<form:checkboxes path="langs" items="${langList}" itemValue="idlang" itemLabel="langname" element="div" />
				</fieldset>
			</td>
		</tr>
		<tr>
			<td><form:label path="skills"><spring:message code="label.skills"/>:</form:label></td>
			<td>
				<fieldset>
				<form:checkboxes path="skills" items="${skillList}" itemValue="idskill" itemLabel="skillname" element="div" />
				</fieldset>
			</td>
		</tr>
		<tr>
		<td><input type="submit" value="<spring:message code="label.save"/>" /></td>
		</tr>
		</table>
	</form:form>
</div>