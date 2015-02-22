<%@ page import="java.util.Random" %>
<HTML>
<BODY>
<FORM METHOD=GET ACTION="SaveName.jsp">
    What's your name? <INPUT TYPE=TEXT NAME=username SIZE=20><BR>
    <%
        int myRnd = new Random().nextInt(1000);
        session.setAttribute(
                "token", Integer.valueOf(myRnd).toString());

    %>
    <INPUT TYPE="HIDDEN" NAME="token"
           VALUE="<%= Integer.valueOf(myRnd).toString() %>">
    <INPUT TYPE=SUBMIT>
</FORM>
</BODY>
</HTML>