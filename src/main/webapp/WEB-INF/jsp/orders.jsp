<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<h1><spring:message code="orders.view"/></h1>
<table border="1">
    <caption><spring:message code="orders.name"/></caption>
    <tr>
        <th>ID</th>
        <th>DATE</th>
        <th>USER ID</th>
        <th>GOODS ID</th>
        <th>EDIT</th>
        <th>DEL</th>
    </tr>
    <c:forEach items="${viewOrders}" var="row">
        <tr>
            <td>
                <c:out value="${row.getId()}"/>
            </td>
            <td>
                <fmt:formatDate value="${row.getDateCreated().date}" var="dateString" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <c:out value="${row.getUserId()}"/>
            </td>
            <td>
                <c:out value="${row.getGoodsId()}"/>
            </td>
            <td>
                <a href="<spring:url value="/orders/edit/${row.getId()}" />">
                    <spring:message code="link.update"/>
                </a>
            </td>
            <td>
                <form method="POST" action="/orders/delete">
                    <input type="hidden" name="id" value="${row.getId()}"/>
                    <input type="submit" value="DEL">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<spring:url value="/orders/add" />"><spring:message code="orders.insert"/></a>
</body>
</html>