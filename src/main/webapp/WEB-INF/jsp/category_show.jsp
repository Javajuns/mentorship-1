<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<h2>Show category</h2>
<a href="<spring:url value="/category" />"><spring:message code="category.view"/></a><br/>

<div>ID:${showCategory.getId()}</div>
<div>Name: ${showCategory.getName()}</div>
<div>Parent: ${showCategory.getParentId()}</div>

<h2>Goods this category</h2>
<table>
    <caption><spring:message code="goods.name"/></caption>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>REST</th>
    </tr>
    <c:forEach items="${showCategory.getGoods()}" var="row">
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
                <c:out value="${row.getRest()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
