package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.springframework.stereotype.Component;
import org.hibernate.Session;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("DELETE FROM category WHERE id = ?");
        updateStmt.setInt(1, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public Category getById(int id) throws SQLException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category WHERE id = ?");
        selectStatement.setInt(1, id);
        ResultSet result = selectStatement.executeQuery();
        result.next();
        Category category = hydrateCategory(result);
        selectStatement.close();
        return category;
    }

    @Override
    public synchronized void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("UPDATE category SET name = ?, parent_id = ? WHERE id = ?");
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public synchronized void addCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category");
        ResultSet result = selectStatement.executeQuery();
        List<Category> categories = new ArrayList<Category>();
        while (result.next()) {
            categories.add(hydrateCategory(result));
        }
        selectStatement.close();
        return categories;
    }

    private Category hydrateCategory(ResultSet result) throws SQLException {
        Category category = new Category();
        category.setId(result.getInt("id"));
        category.setName(result.getString("name"));
        category.setParentId(result.getInt("parent_id"));
        return category;
    }
}
