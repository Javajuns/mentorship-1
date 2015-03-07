<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="users.update"/></h1>
<a href="<spring:url value="/users" />"><spring:message code="users.view"/></a>
<form:form method="POST" action="/users/update" modelAttribute="update_form">
    <div>
        <form:hidden path="id"/>
    </div>
    <div>
        <form:label path="login"><spring:message code="users.col.login"/></form:label>
        <form:input path="login"/>
        <form:errors path="login"/>
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
        <form:label path="dateCreated"><spring:message code="users.col.date-created"/></form:label>
        <form:input path="dateCreated"/>
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