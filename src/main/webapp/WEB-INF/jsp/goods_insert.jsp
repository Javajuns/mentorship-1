<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="goods.insert"/></h1>
<a href="<spring:url value="/goods" />"><spring:message code="goods.view"/></a>
<form:form method="POST" action="/goods/save" modelAttribute="insert_form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="name"><spring:message code="goods.col.name"/></form:label>
        <form:input path="name"/>
        <form:errors path="name" element="div"/>
    </div>
    <div>
        <form:label path="price"><spring:message code="goods.col.price"/></form:label>
        <form:input path="price"/>
        <form:errors path="price" element="div"/>
    </div>
    <div>
        <form:label path="categoryId"><spring:message code="goods.col.categoryId"/></form:label>
        <form:select path="categoryId">
            <form:option value="0" label="--- Select ---"/>
            <form:options items="${parentCategories}"/>
        </form:select>
    </div>
    <div>
        <form:label path="name"><spring:message code="goods.col.rest"/></form:label>
        <form:input path="rest"/>
        <form:errors path="rest" element="div"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>