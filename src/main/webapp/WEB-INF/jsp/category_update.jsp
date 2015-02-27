<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="category.update"/></h1>
<a href="<spring:url value="/" />"><spring:message code="category.view"/></a>
<form:form method="POST" action="/category_update.html" modelAttribute="update_form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="id"><spring:message code="update.id"/></form:label>
        <form:input path="id"/>
    </div>
    <div>
        <form:label path="name"><spring:message code="update.name"/></form:label>
        <form:input path="name"/>
    </div>
    <div>
        <form:label path="parent_id"><spring:message code="update.parent_id"/></form:label>
        <form:input path="parent_id"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>