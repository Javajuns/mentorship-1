<%@ page import="java.util.Random" %>
<html>
<body>
<form method="GET" action="SaveName.jsp">
    What's your name? <input type="text" name="username" size="20"><br/>
    <%  
        java.lang.String randomToken = Integer.valueOf(new Random().nextInt(1000)).toString();
        session.setAttribute("token", randomToken );
    %>
    <input type="hidden" name="token" value="<%= randomToken %>">
    <input type=submit>

</form>
</body>
</html>