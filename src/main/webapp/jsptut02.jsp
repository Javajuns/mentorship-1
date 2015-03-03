<%@ page import="java.util.Properties" %>
<%@ page import="java.util.Map" %>
<HTML>
<BODY>
<%
    Properties props = System.getProperties();
    for (Map.Entry<Object, Object> p : props.entrySet() ) {
        out.print("Parametr: " + p.getKey());
        out.print("\t\t\tValue: " + p.getValue());
%>
    <BR>
<%
    }
%>
<%
    boolean hello = true;
    if ( hello ) {
%>
<P>Hello, world
        <%
    } else {
        %>
<P>Goodbye, world
        <%
    }
%>
</BODY>
</HTML>