<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-header">
<h1><spring:message code="label.company_list"/></h1>
</div>
<div class="row">
<c:if test="${!empty companyList}">
<table class="table table-striped">
	<thead>
	<tr>
		<th><spring:message code="label.company_name"/></th>
		<th><spring:message code="label.contacts"/></th>
		<th>&nbsp;</th>
		<th>&nbsp;</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${companyList}" var="c">
	<tr>
		<td>${c.name}</td>
		<td>${c.contacts}</td>
		<td>
			<a href="deleteCompany${c.idcompany}.do">
				<button type="button" class="btn btn-danger"><spring:message code="label.delete"/></button>
			</a>
		</td>
		<td>
			<a href="showVacByCompany${c.idcompany}.do">
				<button type="button" class="btn btn-info"><spring:message code="label.show_all_vacancies"/></button>
			</a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${empty companyList}"><p><spring:message code="label.no_companies"/></p></c:if>
</div>
<div class="page-header">
<h1><spring:message code="label.add_company"/></h1>
</div>
<div class="row">
<form:form action="addCompany.do" commandName="newCompany" method="post">
	<table class="table">
		<tr>
			<td><spring:message code="label.company_name"/></td>
			<td>
				<div class="col-xs-6">
				<input type="text" class="form-control" name="name" required/>
				</div>
			</td>
		</tr>
		<tr>
			<td><spring:message code="label.contacts"/></td>
			<td>
				<div class="col-xs-6">
				<input type="text" class="form-control" name="contacts"/>
				</div>
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" class="btn btn-primary" value="<spring:message code="label.add"/>" />
			</td>
		</tr>
	</table>
</form:form>
</div>