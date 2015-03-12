<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<h1><spring:message code="category.view"/></h1>
<table>
    <caption><spring:message code="category.name"/></caption>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PARENT ID</th>
        <th>EDIT</th>
        <th>DEL</th>
    </tr>
    <c:forEach items="${viewCategory}" var="row">
        <tr>
            <td>
                <a href="<spring:url value="/category/show/${row.getId()}" />"/>
                <spring:message text="${row.getId()}"/>
            </td>
            <td>
                <c:out value="${row.getName()}"/>
            </td>
            <td>
                <c:out value="${row.getParentId()}"/>
            </td>
            <td>
                <a href="<spring:url value="/category/edit/${row.getId()}" />"/>
                    <spring:message code="link.update"/>
                </a>
            </td>
            <td>
                <form method="POST" action="/category/delete">
                    <input type="hidden" name="id" value="${row.getId()}"/>
                    <input type="submit" value="DEL">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<spring:url value="/category/add" />"><spring:message code="category.insert"/></a>
</body>
</html>