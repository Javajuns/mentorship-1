<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="category.insert"/></h1>
<a href="<spring:url value="/category" />"><spring:message code="category.view"/></a>
<form:form method="POST" action="/categoryInsert" modelAttribute="form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="id"><spring:message code="insert.name"/></form:label>
        <form:input path="id"/>
        <form:errors path="id"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>