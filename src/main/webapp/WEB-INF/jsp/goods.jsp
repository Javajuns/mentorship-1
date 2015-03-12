<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<h1><spring:message code="goods.view"/></h1>
<table>
    <caption><spring:message code="goods.name"/></caption>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>CATEGORY</th>
        <th>REST</th>
        <th>EDIT</th>
        <th>DEL</th>
    </tr>
    <c:forEach items="${viewGoods}" var="row">
        <tr>
            <td>
                <c:out value="${row.getId()}"/>
            </td>
            <td>
                <c:out value="${row.getName()}"/>
            </td>
            <td>
                <c:out value="${row.getPrice()}"/>
            </td>
            <td>
                <a href="/category/edit/${row.getCategory().getId()}"><c:out value="${row.getCategory().getName()}"/></a>
            </td>
            <td>
                <c:out value="${row.getRest()}"/>
            </td>
            <td>
                <a href="<spring:url value="/goods/edit/${row.getId()}"/>">
                    <spring:message code="link.update"/>
                </a>
            </td>
            <td>
                <form method="POST" action="/goods/delete">
                    <input type="hidden" name="id" value="${row.getId()}"/>
                    <input type="submit" value="DEL">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<spring:url value="/goods/add" />"><spring:message code="goods.insert"/></a>
</body>
</html>