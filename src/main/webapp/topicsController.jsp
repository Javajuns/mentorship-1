<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%
    int result = 0;
    if (request.getMethod().equals("POST")) {
        String id = request.getParameter("id");
        String subject = request.getParameter("user_id");
        String text = request.getParameter("user_id");
        String is_closed = request.getParameter("goods_id");
        String date_created = request.getParameter("date_created");

        if ("Update".equals(request.getParameter("Update")) && !"".equals(id) && !"".equals(subject) && !"".equals(text) && !"".equals(is_closed) && !"".equals(date_created))
            result = DBImpl.update("UPDATE forum_topics SET date_created='" + date_created + "', text='" + text + "', is_closed='" + is_closed + "', subject='" + subject + "' WHERE ID=" + id);
        if ("Insert".equals(request.getParameter("Insert")) && !"".equals(date_created) && !"".equals(text) && !"".equals(is_closed) && !"".equals(subject))
            result = DBImpl.update(
                    "INSERT INTO forum_topics (id, subject,text, is_closed, date_created ) VALUES (null,'"
                            + subject + "','"
                            + text + "','"
                            + is_closed + "','"
                            + date_created + "')");
    }

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Upd", "topicsView.jsp");
%>