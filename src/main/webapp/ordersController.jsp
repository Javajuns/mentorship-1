<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%
    int result = 0;
    if (request.getMethod().equals("POST")) {
        String id = request.getParameter("id");
        String date_created = request.getParameter("date_created");
        String user_id = request.getParameter("user_id");
        String goods_id = request.getParameter("goods_id");
        String amount = request.getParameter("amount");
        // ACTION LOGIC
        // ID (NOT NULL), NAME (NULL), PARENT_ID (NULL) - try to delete row contains id
        // ID (NOT NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to update row contains id
        // ID (NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to insert row

        if ("Remove".equals(request.getParameter("Remove")) && !"".equals(id))
            result = DBImpl.update("DELETE FROM public.orders WHERE ID=" + id);
        if ("Update".equals(request.getParameter("Update")) && !"".equals(id) && !"".equals(date_created) && !"".equals(user_id) && !"".equals(goods_id) && !"".equals(amount))
            result = DBImpl.update("UPDATE orders SET date_created='" + date_created + "', user_id='" + user_id + "', goods_id='" + goods_id + "', amount='" + amount + "' WHERE ID=" + id);
        if ("Insert".equals(request.getParameter("Insert")) && !"".equals(date_created) && !"".equals(user_id) && !"".equals(goods_id) && !"".equals(amount))
            result = DBImpl.update(
                    "INSERT INTO orders (id,date_created,user_id, goods_id, amount ) VALUES (null,'"
                            + date_created + "','"
                            + user_id + "','"
                            + goods_id + "','"
                            + amount + "')");
    }

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "ordersView.jsp");
%>