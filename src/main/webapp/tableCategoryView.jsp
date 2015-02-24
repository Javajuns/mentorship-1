<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.lang.model.type.NullType" %>
<html>
<head>
    <title>TABLE CATEGORY</title>
</head>
<body>

<form method="POST" action="tableCategoryController.jsp">
    <table border="1">
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>PARENT ID</td>
        </tr>
        <%
            ResultSet result = DBImpl.select("SELECT * FROM category");
            while (result.next()) {
                out.println("<tr>");
                out.println("<td>");
                out.println(result.getInt("id"));
                out.println("</td>");
                out.println("<td>");
                out.println(result.getString("name"));
                out.println("</td>");
                out.println("<td>");
                out.println(result.getInt("parent_id"));
                out.println("</td>");
                out.println("</tr>");
            }
        %>
        <tr>
            <td><input type="text" name="id"/></td>
            <td><input type="text" name="name"/></td>
            <td><input type="text" name="parent_id"/></td>
        </tr>
    </table>
    <input type="submit" name="Insert" value="Insert"/>
    <input type="submit" name="Update" value="Update"/>
    <input type="submit" name="Remove" value="Remove"/>
</form>
</body>
</html>
