<%@ page import="java.util.Random" %>
<html>
<body>
<form method="GET" action="SaveName.jsp">
    What's your name? <input type="text" name="username" size="20"><br/>
    <%
        int myRnd = new Random().nextInt(1000);
        session.setAttribute(
                "token", Integer.valueOf(myRnd).toString());

    %>
    <input type="hidden" name="token"
           value="<%= Integer.valueOf(myRnd).toString() %>">
    <input type="submit" value="Send Name">
</form>
</body>
</html>