<%@ page import="java.util.Date" %>
<HTML>
<BODY>
<%
    System.out.println( "Evaluating date now" );
    Date date = new Date();
%>
Hello!  The time is now <%= date %>
</BODY>
</HTML>