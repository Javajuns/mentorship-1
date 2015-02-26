package com.github.javamentorship.controller;

import com.github.javamentorship.mentorship.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CategoryController extends HttpServlet {

    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = new CategoryDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer parentId = Integer.valueOf(req.getParameter("parent_id"));

        try {
            if (checkParameter("Remove", req)){

            }
            if (checkParameter("Update", req)){
                categoryDao.update(name, parentId, id);
            }

            if (checkParameter("Insert", req)){
                categoryDao.insert(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", "/tableCategoryView.jsp");
    }

    private boolean checkParameter(String param, HttpServletRequest request1) {
        return param.equals(request1.getParameter(param));
    }

}
