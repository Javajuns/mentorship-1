<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View table</title>
</head>
<body>
<%--
${categories.size()}
${categories.get(0)}
--%>

<%
    //TODO WTF? атрибут из реквеста? Это как?
//    List<Map<String, Object>> getData = (List) request.getAttribute("categories");
//    for (Map<String, Object> row : getData) {
//        for (Map.Entry<String, Object> data : row.entrySet()) {
//            out.println("KEY: " + data.getKey() + " ");
//            out.println("VALUE" + data.getValue() + "<br/>");
//        }
//    }
%>

</body>
</html>
