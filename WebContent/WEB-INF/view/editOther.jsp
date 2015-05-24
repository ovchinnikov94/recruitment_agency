<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
<h1><spring:message code="label.edit_other_page"/></h1>
</div>
<div class="row">
<table class="table table-striped">
	<tr>
		<td><spring:message code="label.add_post"/>:</td>
        <td>
        	<form:form  method="post" action="addNewPost.do"  commandName="post" data-toggle="validator" class="form-inline">
        		<input name="postname" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
        		<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
        <td><spring:message code="label.add_sphere"/>:</td>
        <td>
       		<form:form  method="post" action="addNewSphere.do"  commandName="sphere" data-toggle="validator" class="form-inline"> 
       			<input name="spherename" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
       			<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
     	<td><spring:message code="label.add_type"/>:</td>
     	<td>
       		<form:form  method="post" action="addNewType.do"  commandName="type" data-toggle="validator" class="form-inline">
       			<input name="typename" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
       			<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_spec"/>:</td>
		<td>
        	<form:form  method="post" action="addNewSpec.do"  commandName="spec" data-toggle="validator" class="form-inline">  
        		<input name="specname" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
        		<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_lang"/>:</td>
		<td>
        	<form:form  method="post" action="addNewLang.do"  commandName="lang" data-toggle="validator" class="form-inline">  
        		<input name="langname" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
        		<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
	<tr>
		<td><spring:message code="label.add_skill"/>:</td>
		<td>
        	<form:form  method="post" action="addNewSkill.do"  commandName="skill" data-toggle="validator" class="form-inline">  
        		<input name="skillname" type="text" pattern="^[а-яА-ЯёЁa-zA-Z ]+$" class="form-control" required/>
        		<input type="submit" class="btn btn-sm btn-primary" value="<spring:message code="label.add"/>" /> 
        	</form:form> 
        </td>
	</tr>
</table>
</div>