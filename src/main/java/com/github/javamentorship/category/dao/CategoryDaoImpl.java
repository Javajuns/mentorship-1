package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Category category = new Category();
        category.setId(result.getInt("id"));
        category.setName(result.getString("name"));
        category.setParentId(result.getInt("parentid"));
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
    public synchronized void addCategory(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("INSERT INTO category (name) VALUES (?)");
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category");
        ResultSet result = selectStatement.executeQuery();
        List<Category> categories = new ArrayList<Category>();
        while (result.next()) {
            Category category = new Category();
            category.setId(result.getInt("id"));
            category.setName(result.getString("name"));
            category.setParentId(result.getInt("parentid"));
            categories.add(category);
        }
        selectStatement.close();
        return categories;
    }
}
