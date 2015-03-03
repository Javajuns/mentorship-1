<%
    String name = request.getParameter("username");
    session.setAttribute("thename", name);
%>
<html>
<body>
<a href="tut_NextPage.jsp">Continue...</a>
</body>
</html>