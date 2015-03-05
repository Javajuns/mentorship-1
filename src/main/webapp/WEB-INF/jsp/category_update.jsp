<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="category.update"/></h1>
<a href="<spring:url value="/category" />"><spring:message code="category.view"/></a>
<form:form method="POST" action="/category/update" modelAttribute="update_form">
    <div>
        <form:label path="id"><spring:message code="category.update.id"/></form:label>
        <form:input path="id"/>
        <form:errors path="id" element="div"/>
    </div>
    <div>
        <form:label path="name"><spring:message code="category.update.name"/></form:label>
        <form:input path="name"/>
        <form:errors path="name" element="div"/>
    </div>
    <div>
        <form:label path="parentId"><spring:message code="category.update.parentId"/></form:label>
        <form:select path="parentId">
            <form:option value="0" label="Root"/>
            <form:options items="${parentCategories}"/>
        </form:select>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>