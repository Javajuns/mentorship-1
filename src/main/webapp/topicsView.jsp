<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.lang.model.type.NullType" %>
<html>
<head>
    <title>Topics</title>
</head>
<body>
<form method="POST" action="topicsController.jsp">
    <div style="float: left">
        <table border="0">
            <tr>
                <td align="center">ID</td>
                <td align="center">SUBJECT</td>
                <td align="center">TEXT</td>
                <td align="center">IS_CLOSED</td>
                <td align="center">DATE_CREATED</td>
            </tr>
            <%
                ResultSet result = DBImpl.select("SELECT * FROM forum_topics");
                while (result.next()) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(result.getInt("id"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(result.getString("subject"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(result.getString("text"));
                    out.println("</td>");
                    out.println("</tr>");
                    out.println(result.getInt("is_closed"));
                    out.println("</td>");
                    out.println("</tr>");
                    out.println(result.getDate("date_created"));
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>

        </table>
    </div>
    <div style="float: right">
        <table border="0">
            <tr>
                <td><input type="text" name="id"/></td>
                <td><input type="text" name="subject"/></td>
                <td><input type="text" name="text"/></td>
                <td><input type="text" name="is_closed"/></td>
                <td><input type="text" name="date_created"/></td>
            </tr>

        </table>
        <input type="submit" name="Insert" value="Insert"/>
        <input type="submit" name="Update" value="Update"/>
    </div>
</form>
</body>
</html>