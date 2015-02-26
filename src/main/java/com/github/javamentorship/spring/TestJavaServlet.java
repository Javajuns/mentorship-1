package com.github.javamentorship.spring;
// Import required java libraries

import com.github.javamentorship.mentorship.CategoryDao;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class TestJavaServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Try use our CategoryDao class
        List<Map<String, Object>> selectTry = null;
        try {
            selectTry = new CategoryDao().listAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        if (selectTry != null) {
            out.println("<table border=\"1\">" +
                    "<caption>CATEGORY</caption><tr>" +
                    "<th>ID</th>" +
                    "<th>NAME</th>" +
                    "<th>PARENT ID</th>" +
                    "</tr>");
            for (Map<String, Object> row : selectTry) {
                out.println("<tr>");
                out.println("<td>");
                out.println(row.get("id"));
                out.println("</td>");
                out.println("<td>");
                out.println(row.get("name"));
                out.println("</td>");
                out.println("<td>");
                out.println(row.get("parent_id"));
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
        } else {
            out.println("");

        }
    }

    public void destroy() {
        // do nothing.
    }
}