<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap-datetimepicker.js"></script>
<script src="resources/js/moment-with-locales.min.js"></script>
<script type="text/javascript">
    $(function () {
      $('#dateFrom').datetimepicker({language: 'ru'});
      $('#dateTo').datetimepicker({language: 'ru'});
    });
  </script>
<div class="page-header">
<h1><a href="showMan${idpeople}.do">${name} ${middlename} ${surname}</a></h1>
</div>
<div class="row">
<p><spring:message code="label.history"/></p>
	<c:if test="${empty listHistory}"><br><br><p><spring:message code="label.empty_list"/></p></c:if>
	<c:if test="${!empty listHistory}">
	<table class="table table-striped">
		<thead>
		<tr>
			<th><spring:message code="label.begin"/></th>
			<th><spring:message code="label.end"/></th>
			<th><spring:message code="label.salary"/></th>
			<th><spring:message code="label.post"/></th>
			<th><spring:message code="label.company"/></th>
			<th> &nbsp;</th>
		</tr>
		</thead>
		<c:forEach items="${listHistory}" var="h">
			<tr>
				<td>${h.dateFrom}</td>
				<td>${h.dateTo}</td>
				<td>${h.salary}</td>
				<td>${h.post.postname}</td>
				<td>${h.company.name}</td>
				<td>
					<a href="deleteHistory${h.idhistory}.do">
						<button type="button" class="btn btn-lg btn-danger"><spring:message code="label.delete" /></button>
					</a>
				</td>
			</tr>	
		</c:forEach>
	</table>
	</c:if>
</div>
<div class="page-header">
<h1><spring:message code="label.add_history"/></h1>
</div>

<div class="row">
	<form:form path="hist" commandName="hist" action="addHist${idpeople}.do">
	<table class="table">
		<tr>
			<td><spring:message code="label.begin"/></td>
			
			<td><input type="text" id="dateFrom" name="dateFrom"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.end"/></td>
			<td><input type="text" id="dateTo" name="dateTo"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.salary"/></td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.post"/></td>
			<td><form:select path="post.idpost" items="${postList}" itemValue="idpost" itemLabel="postname"/></td>
		</tr>
		<tr>
			<td><spring:message code="label.company"/></td>
			<td><form:select path="company.idcompany" items="${companyList}" itemValue="idcompany" itemLabel="name"/></td>
		</tr>
		<tr>
			<spring:message code="label.add" var="k"/>
			<td><input type="submit" value="${k}" /></td>
		</tr>
	</table>
	</form:form>
</div>

