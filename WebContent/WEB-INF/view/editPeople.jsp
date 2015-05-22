<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-header">
<h1>${man.name} ${man.surname}</h1>
</div>
<div class="row">
<form:form method="post" commandName="man" action="${action}">
    <table class="table table-striped">
    <tr>
        <td><form:label path="name"><spring:message code="label.firstname"/>*</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="surname"><spring:message code="label.surname"/>*</form:label></td>
        <td><form:input path="surname" /></td>
    </tr>
    <tr>
        <td><form:label path="middlename"><spring:message code="label.middlename"/></form:label></td>
        <td><form:input path="middlename" /></td>
    </tr>
    <tr>
        <td><form:label path="age"><spring:message code="label.age"/>*</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td><form:label path="salary"><spring:message code="label.salary"/>*</form:label></td>
        <td><form:input path="salary" /></td>
    </tr>
    <tr>
        <td><form:label path="contacts"><spring:message code="label.contacts"/></form:label></td>
        <td><form:input path="contacts" /></td>
    </tr>
    <tr>
        <td><form:label path="studyplace"><spring:message code="label.studyplace"/></form:label></td>
        <td><form:input path="studyplace" /></td>
    </tr>
    <tr>
        <td><form:label path="post.idpost"><spring:message code="label.post"/>*</form:label></td>
        <td>
        	<form:select path="post.idpost">
        		<form:options items="${postList}" itemLabel="postname" itemValue="idpost"></form:options>
        	</form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="sphere.idsphere"><spring:message code="label.sphere"/>*</form:label></td>
        <td>
        	<form:select path="sphere.idsphere">
        		<form:options items="${sphereList}" itemLabel="spherename" itemValue="idsphere"></form:options>
        	</form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="type.idtype"><spring:message code="label.edutype"/>*</form:label></td>
        <td>
        	<form:select path="type.idtype" items="${typeList}" itemValue="idtype" itemLabel="typename">
        	</form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="spec.idspec"><spring:message code="label.spec"/>*</form:label></td>
        <td>
        	<form:select path="spec.idspec" items="${specList}" itemValue="idspec" itemLabel="specname"/>
        </td>
    </tr>
    <tr>
        <td>
        	<form:label path="langs"><spring:message code="label.langs"/>:</form:label>
        	
        </td>
    	<td>
    		<fieldset>
    			<form:checkboxes items="${langList}" path="langs" itemValue="idlang" itemLabel="langname"
    				element="div"/>
    		</fieldset>
    	</td>
    </tr>
    <tr>
        <td>
        	<form:label path="skills"><spring:message code="label.skills"/>:</form:label>
        </td>
    	<td>
    		<fieldset>
    			<form:checkboxes items="${skillList}" path="skills" itemValue="idskill" itemLabel="skillname"
    				element="div"/>
    		</fieldset>
    	</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.save"/>"/>
        </td>
    </tr>

</table> 
</form:form>
</div>