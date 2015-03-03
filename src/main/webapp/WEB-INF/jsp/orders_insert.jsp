<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1><spring:message code="orders.insert"/></h1>
<a href="<spring:url value="/orders" />"><spring:message code="orders.view"/></a>
<form:form method="POST" action="/orders/save" modelAttribute="insert_form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path=""><spring:message code="orders.col.date"/></form:label>
    </div>
    <div>
        <form:input path="dateCreated"/>
        <form:errors path="dateCreated" element="div"/>
    </div>
    <div>
        <form:label path="userId"><spring:message code="orders.col.userId"/></form:label>
        <form:select path="userId">
            <form:option value="0" label="--- Select ---"/>
            <form:options items="${parentUsers}"/>
        </form:select>
    </div>
    <div>
        <form:label path="goodsId"><spring:message code="orders.col.goodsId"/></form:label>
        <form:select path="goodsId">
            <form:option value="0" label="--- Select ---"/>
            <form:options items="${parentGoods}"/>
        </form:select>
    </div>
    <div>
        <form:input path="amount"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>