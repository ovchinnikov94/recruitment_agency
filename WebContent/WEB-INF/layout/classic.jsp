<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="label.${page_name}" /></title>

<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/css/bootstrap-datetimepicker.css">
<link rel="stylesheet"
	href="resources/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
<script
	src="resources/js/validator.js"></script>


</head>
<body role="document">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="search.do"><spring:message
							code="label.ragency" /></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li <c:if test="${page_name.compareTo(\"search_page\") == 0}">class="active"</c:if> >
							<a href="search.do"><spring:message
									code="label.search"/></a></li>
						<li <c:if test="${page_name.compareTo(\"vacancy_list\") == 0}">class="active"</c:if> >
							<a href="vacancies.do"><spring:message
									code="label.vacancies" /></a></li>
						<li <c:if test="${page_name.compareTo(\"people_list\") == 0}">class="active"</c:if> >
							<a href="people.do"><spring:message
									code="label.people"/></a></li>
						<li <c:if test="${page_name.compareTo(\"company_list\") == 0}">class="active"</c:if> >
							<a href="companies.do"><spring:message
									code="label.companies"/></a></li>
						<li <c:if test="${page_name.compareTo(\"edit_other_page\") == 0}">class="active"</c:if> >
							<a href="other.do"><spring:message
									code="label.other_parametres"/></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	<div class="container theme-showcase" role="main">
	<br>
	<br>
	<tiles:insertAttribute name="body" />
	<br>
	<br>
	</div>
	<center>
		<tiles:insertAttribute name="footer" />
	</center>
	
</body>
</html>