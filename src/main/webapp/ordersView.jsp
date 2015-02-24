<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javax.lang.model.type.NullType" %>
<html>
<head>
  <title>ORDERS</title>
</head>
<body>

<form method="POST" action="ordersController.jsp">
  <table border="0">
    <tr>
      <td align="center">ID</td>
      <td align="center">DATE CREATED <p><font size="1">Format: yyy-mm-dd</font></p></td>
      <td align="center">USER ID</td>
      <td align="center">GOODS ID</td>
      <td align="center">AMOUNT</td>
    </tr>
    <%
      ResultSet result = DBImpl.select("SELECT * FROM orders");
      while (result.next()) {
        out.println("<tr>");
        out.println("<td>");
        out.println(result.getInt("id"));
        out.println("</td>");
        out.println("<td>");
        out.println(result.getString("date_created"));
        out.println("</td>");
        out.println("<td>");
        out.println(result.getInt("user_id"));
        out.println("</td>");
        out.println("</tr>");
        out.println(result.getInt("goods_id"));
        out.println("</td>");
        out.println("</tr>");
        out.println(result.getInt("amount"));
        out.println("</td>");
        out.println("</tr>");
      }
    %>
    <tr>
      <td><input type="text" name="id"/></td>
      <td><input type="text" name="date_created"/></td>
      <td><input type="text" name="user_id"/></td>
      <td><input type="text" name="goods_id"/></td>
      <td><input type="text" name="amount"/></td>
    </tr>
  </table>
  <input type="submit" name="Insert" value="Insert"/>
  <input type="submit" name="Update" value="Update"/>
  <input type="submit" name="Remove" value="Remove"/>
</form>
</body>
</html>
