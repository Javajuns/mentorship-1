<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
<h1><spring:message code="users.view"/></h1>
Hello
<%= session.getAttribute("login") %>
<table border="1">
    <caption><spring:message code="users.name"/></caption>
    <tr>
        <th>ID</th>
        <th>LOGIN</th>
        <th>FIRST NAME</th>
        <th>SECOND_NAME</th>
        <th>EMAIL</th>
        <th>CREATED</th>
        <th>ADMIN</th>
        <th>EDIT</th>
        <th>DEL</th>
    </tr>
    <c:forEach items="${viewUsers}" var="row">
        <tr>
            <td>
                <c:out value="${row.getId()}"/>
            </td>
            <td>
                <c:out value="${row.getLogin()}"/>
            </td>
            <td>
                <c:out value="${row.getFirstName()}"/>
            </td>
            <td>
                <c:out value="${row.getSecondName()}"/>
            </td>
            <td>
                <c:out value="${row.getEmail()}"/>
            </td>
            <td>
                <c:out value="${row.getDateCreated()}"/>
            </td>
            <td>
                <c:out value="${row.getIsAdmin()}"/>
            </td>
            <td>
                <a href="<spring:url value="/users/edit/${row.getId()}" />">
                    <spring:message code="link.update"/>
                </a>
            </td>
            <td>
                <form method="POST" action="/users/delete">
                    <input type="hidden" name="id" value="${row.getId()}"/>
                    <input type="submit" value="DEL">
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <td>
                    <%--<a href="<spring:url value="/users/addr/${row.getAddress().getId()}" />"/>--%>
                <spring:message text="Адрес:"/>
            </td>
            <td>${row.getAddress().getCountry()}</td>
            <td>${row.getAddress().getCity()}</td>
            <td>${row.getAddress().getStreet()}</td>
            <td>${row.getAddress().getBuilding()}</td>

        </tr>
    </c:forEach>
</table>
<a href="<spring:url value="/users/add" />"><spring:message code="users.insert"/></a>
</body>
</html>