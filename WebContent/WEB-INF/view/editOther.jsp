<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1><spring:message code="label.edit_other_page"/></h1>
</div>
<div class="row">
<table class="table">
	<tr>
		<td><spring:message code="label.add_post"/>:</td>
        <td>
        	<form:form  method="post" action="addNewPost.do"  commandName="post">
        		<form:input path="postname" />
        		<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
        <td><spring:message code="label.add_sphere"/>:</td>
        <td>
       		<form:form  method="post" action="addNewSphere.do"  commandName="sphere"> 
       			<form:input path="spherename" />
       			<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
     	<td><spring:message code="label.add_type"/>:</td>
     	<td>
       		<form:form  method="post" action="addNewType.do"  commandName="type">
       			<form:input path="typename" />
       			<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_spec"/>:</td>
		<td>
        	<form:form  method="post" action="addNewSpec.do"  commandName="spec">  
        		<form:input path="specname" />
        		<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_lang"/>:</td>
		<td>
        	<form:form  method="post" action="addNewLang.do"  commandName="lang">  
        		<form:input path="langname" />
        		<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_skill"/>:</td>
		<td>
        	<form:form  method="post" action="addNewSkill.do"  commandName="skill">  
        		<form:input path="skillname" />
        		<input type="submit" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
</table>
</div>