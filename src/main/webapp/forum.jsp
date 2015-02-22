<%@ page import="com.github.javamentorship.mentorship.DB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
<%
    if (request.getMethod().equals("POST")) {
        String comment = request.getParameter("comment");
        DB.comments.add(comment);
    }

    for (String comment: DB.comments) {
        out.println(comment + "<br/>");
    }
%>

<form method="post" action="forum.jsp">
    <textarea name="comment"></textarea><br/>
    <input type="submit" value="Post a comment"/>
</form>


</body>
</html>
