<%
    String name = request.getParameter("username");
    String email = request.getParameter("email");
    session.setAttribute("thename", name);
    session.setAttribute("themail", email);
%>
<html>
<body>
<a href="tut_NextPage.jsp">Continue...</a>
</body>
</html>