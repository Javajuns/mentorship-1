<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="category.insert"/></h1>
<a href="<spring:url value="/category" />"><spring:message code="category.view"/></a>
<form:form method="POST" action="/category_insert.html" modelAttribute="insert_form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="name"><spring:message code="insert.name"/></form:label>
    </div>
    <div>
        <form:input path="name"/>
    </div>
    <div>
        <form:label path="parentId"><spring:message code="insert.parentId"/></form:label>
    </div>
    <div>
        <form:select path="parentId">
            <form:option value="0" label="--- Select ---"/>
            <form:options items="${parentCategories}" />
        </form:select>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>