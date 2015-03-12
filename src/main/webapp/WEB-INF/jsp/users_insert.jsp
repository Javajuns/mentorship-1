<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="users.insert"/></h1>
<a href="<spring:url value="/users" />"><spring:message code="users.view"/></a>

<h2>Данные пользователя</h2>
<form:form method="POST" action="/users/save" modelAttribute="insert_form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="login"><spring:message code="users.col.login"/></form:label>
        <form:input path="login"/>
    </div>
    <div>
        <form:label path="firstName"><spring:message code="users.col.first-name"/></form:label>
        <form:input path="firstName"/>
    </div>
    <div>
        <form:label path="secondName"><spring:message code="users.col.second-name"/></form:label>
        <form:input path="secondName"/>
    </div>
    <div>
        <form:label path="email"><spring:message code="users.col.email"/></form:label>
        <form:input path="email"/>
    </div>
    <div>
        <form:label path="isAdmin"><spring:message code="users.col.isadmin"/></form:label>
        <form:input path="isAdmin"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>