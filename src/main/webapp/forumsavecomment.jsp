<%@ page import="com.github.javamentorship.mentorship.DB" %>
<%

    if (request.getMethod().equals("POST")) {
        String comment = request.getParameter("comment");

        if("SendMessage".equals(request.getParameter("send")))
        {
            DB.comments.add(comment);
        }

        if("Clear".equals(request.getParameter("clear"))){
            DB.comments.clear();
        }
    }

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "profeg-xss-vulnerability.jsp");

%>