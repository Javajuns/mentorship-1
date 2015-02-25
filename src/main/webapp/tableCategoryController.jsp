<%@ page import="com.github.javamentorship.mentorship.CategoryDao" %>
<%
    if (request.getMethod().equals("POST")) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer parentId = Integer.valueOf(request.getParameter("parent_id"));
        // ACTION LOGIC
        // ID (NOT NULL), NAME (NULL), PARENT_ID (NULL) - try to delete row contains id
        // ID (NOT NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to update row contains id
        // ID (NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to insert row

        if ("Remove".equals(request.getParameter("Remove")))
            //result = DBImpl.update("DELETE FROM category WHERE ID=" + id);
        if ("Update".equals(request.getParameter("Update"))) {
            CategoryDao.update(name, parentId, id);
        }
        if ("Insert".equals(request.getParameter("Insert"))) {
            CategoryDao.insert(name);
        }
    }
    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "tableCategoryView.jsp");
%>