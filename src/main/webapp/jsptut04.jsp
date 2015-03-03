<%@ page import="java.util.Date" %>
<HTML>
<BODY>
<%!
    Date theDate = new Date();
    Date getDate()
    {
        System.out.println( "In getDate() method" );
        return theDate;
    }
%>
<%!
    Date computeDate()
    {
        System.out.println( "In computeDate() method" );
        Date theDate = new Date();
        return theDate;
    }
%>
Hello!  The time is now <%= getDate() %>
<p>And real time is now:</p> <%= computeDate()%>
</BODY>
</HTML>