<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form method="POST" action="/users/login">
    Input login:
    <div>
        <input type="text" name="login"/>
        <input type="submit" name="continue"/>
    </div>
</form>
</body>
</html>