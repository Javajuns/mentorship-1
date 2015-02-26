package com.github.javamentorship.controller;

import com.github.javamentorship.mentorship.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CategoryController extends HttpServlet {

    private HttpServletRequest request;
    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = new CategoryDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        request = req;

        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer parentId = Integer.valueOf(req.getParameter("parent_id"));

        try {
            if (checkParameter("Remove")){

            }
            if (checkParameter("Update")){
                categoryDao.update(name, parentId, id);
            }

            if (checkParameter("Insert")){
                categoryDao.insert(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", "/mentorship/tableCategoryView.jsp");
    }

    private boolean checkParameter(String param) {
        return param.equals(request.getParameter(param));
    }

}
