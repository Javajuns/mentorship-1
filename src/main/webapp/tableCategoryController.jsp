<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%
    int result = 0;
    if (request.getMethod().equals("POST")) {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String parentId = request.getParameter("parent_id");
        // ACTION LOGIC
        // ID (NOT NULL), NAME (NULL), PARENT_ID (NULL) - try to delete row contains id
        // ID (NOT NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to update row contains id
        // ID (NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to insert row 

        if ("Remove".equals(request.getParameter("Remove")) && !"".equals(id))
            result = DBImpl.update("DELETE FROM category WHERE ID=" + id);
        if ("Update".equals(request.getParameter("Update")) && !"".equals(id) && !"".equals(name) && !"".equals(parentId))
            result = DBImpl.update("UPDATE category SET NAME='" + name + "', PARENT_ID='" + parentId + "' WHERE ID=" + id);
        if ("Insert".equals(request.getParameter("Insert")) && !"".equals(name) && !"".equals(parentId))
            result = DBImpl.update("INSERT INTO category (id,name,parent_id) VALUES (null,'" + name + "','" + parentId + "')");
    }

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    /*if (result > 0) response.setHeader("result", "OK. " + String.valueOf(result) + " row affected.");
    else response.addHeader("result", "");*/
    response.setHeader("Location", "tableCategoryView.jsp");

%>