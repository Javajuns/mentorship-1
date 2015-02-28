package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Dao implements CategoryDao {
    public Dao() {
    }

    public synchronized void deleteCategory(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("DELETE FROM category WHERE ID=?");
        updateStmt.setInt(1, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("UPDATE category SET name = ?, parent_id = ? WHERE id = ?");
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized void addCategory(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("INSERT INTO category (name) VALUES (?)");
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category");
        ResultSet result = selectStatement.executeQuery();
        List<Category> categories = new ArrayList<Category>();
        while (result.next()) {
            Category row = new Category();
            row.setId(result.getInt("id"));
            row.setName(result.getString("name"));
            row.setParentId(result.getInt("parentid"));
            categories.add(row);
        }
        selectStatement.close();
        return categories;
    }
}
