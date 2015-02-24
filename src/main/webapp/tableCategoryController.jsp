<%@ page import="com.github.javamentorship.mentorship.DBImpl" %>
<%
    int result = 0;
    if (request.getMethod().equals("POST")) {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer parent_id = Integer.valueOf(request.getParameter("parent_id"));
        // ACTION LOGIC
        // ID (NOT NULL), NAME (NULL), PARENT_ID (NULL) - try to delete row contains id
        // ID (NOT NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to update row contains id
        // ID (NULL), NAME (NOT NULL), PARENT_ID (NOT NULL) - try to insert row



        if ("Remove".equals(request.getParameter("Remove")))
            result = DBImpl.update("DELETE FROM category WHERE ID=" + id);
        if ("Update".equals(request.getParameter("Update")))
            //result = DBImpl.update("UPDATE category SET NAME='" + name + "', PARENT_ID='" + parent_id + "' WHERE ID=" + id);
            DBImpl.update(name, parent_id, id);
        if ("Insert".equals(request.getParameter("Insert")))
            result = DBImpl.update("INSERT INTO category (id,name,parent_id) VALUES (" + id + ",'" + name + "','" + parent_id + "')");
            //DBImpl.insert(name, parent_id, id);
    }

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    /*if (result > 0) response.setHeader("result", "OK. " + String.valueOf(result) + " row affected.");
    else response.addHeader("result", "");*/
    response.setHeader("Location", "tableCategoryView.jsp");

%>