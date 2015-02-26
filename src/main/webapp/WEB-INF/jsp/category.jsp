<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1><spring:message code="table.view"/></h1>

<table border="1">
    <caption>CATEGORY</caption>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PARENT ID</th>
        <th>EDIT</th>
        <th>REMOVE</th>
    </tr>
    <c:forEach items="${categories}" var="row">
        <tr>
            <td>
                <c:out value="${row.get('id')}"/>
            </td>
            <td>
                <c:out value="${row.get('name')}"/>
            </td>
            <td>
                <c:out value="${row.get('parent_id')}"/>
            </td>
            <td>
                <a href="/categoryUpdate"/>
            </td>
            <td>
                <a href="/category"
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>