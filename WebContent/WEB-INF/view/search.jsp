<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1><spring:message code="label.search"/></h1>
</div>
<div class="row">
<form:form action="implSearch.do" method="post" commandName="searchQueryForm" >	
	<table class="table">
		<tr>
			<td><form:input size="40" path="searchQuery"/></td>
			<td><input type="submit"  value="<spring:message code="label.search"/>"/></td>
		</tr>
		<tr>
			<td>
				<spring:message code="label.vacancies" var="vlabel"/>
				<spring:message code="label.people" var="plabel" />
				<form:radiobutton path="place" value="vacancy" checked="checked" label="${vlabel}"/>
				
			</td>
			<td><form:radiobutton path="place" value="people" label="${plabel}"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.salary"/>:</td>
			<td>
				<spring:message code="label.from" />
				<form:input path="minSal"/> 
				<spring:message code="label.to"/>
				<form:input path="maxSal"/>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.sphere"/>:</td>
			<td>
				<form:select path="idsphere">
					<form:option value="0" selected="selected">-------</form:option>
					<c:forEach items="${sphereList}" var="s">
					<form:option value="${s.idsphere}">${s.spherename}</form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.edutype"/>:</td>
			<td>
				<form:select path="idtype">
					<form:option value="0" selected="selected">-------</form:option>
					<c:forEach items="${typeList}" var="t">
					<form:option value="${t.idtype}">${t.typename}</form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.langs"/>:</td>
			<td><form:checkboxes items="${langList}" path="langs" itemValue="idlang" itemLabel="langname" element="br"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.skills"/>:</td>
			<td><form:checkboxes items="${skillList}" path="skills" itemValue="idskill" itemLabel="skillname" element="br"/></td>
		</tr>
	</table>
</form:form>
</div>