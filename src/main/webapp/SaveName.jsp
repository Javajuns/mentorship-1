<html>
<body>

<%= session.getAttribute("token") %>
<br />
<%= request.getParameter("token") %>
<br />
<%= request.getHeader("Referer") %>


<%
    /*if (session.getAttribute("token") != null
            && session.getAttribute(
            "token").equals(request.getParameter("token"))) {
        session.setAttribute("token", null);*/
    if(request.getMethod().equals("POST")) {
        session.setAttribute("username", request.getParameter("username"));
    }
    else
    {
        out.println("<br>Get unsupported!");
    }
   /* } else {
        out.println("<br>Form was double submitted!");
    }*/
%>

</body>
</html>