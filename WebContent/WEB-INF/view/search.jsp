<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1><spring:message code="label.search"/></h1>
</div>
<div class="row">
<form:form action="implSearch.do" method="post" commandName="searchQueryForm" data-toggle="validator">	
		<div class="form-group col-xs-7">
			<input type="text" class="form-control" pattern="^[а-яА-ЯёЁa-zA-Z]+$" name="searchQuery"/>
		</div>
		<div class="form-group">
			<spring:message code="label.vacancies" var="vlabel"/>
			<spring:message code="label.people" var="plabel" />
			<form:radiobutton path="place" style="padding:5px; margin:10px;" value="vacancy" checked="checked" label="${vlabel}"/>
			<form:radiobutton path="place" style="padding:5px; margin:10px;" value="people" label="${plabel}"/>
		</div>
	<table class="table table-striped">
		<tr>
			<td><spring:message code="label.salary"/>:</td>
			<td>
				<div class="form-group">
					<div class="col-xs-2">
						<span class="input-group-addon"><spring:message code="label.from" /></span>
						<input type="number" value="0" class="form-control" name="minSal"/> 
					</div>
					
					<div class="col-xs-2">
						<span class="input-group-addon"><spring:message code="label.to"/></span>
						<input type="number" value="0"  class="form-control" name="maxSal"/>
					</div>
				</div>
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
	<div class="form-group">
		<input type="submit" class="btn btn-lg btn-primary" value="<spring:message code="label.search"/>"/>
	</div>
</form:form>
</div>