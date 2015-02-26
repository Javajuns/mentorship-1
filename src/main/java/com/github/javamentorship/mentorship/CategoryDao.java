package com.github.javamentorship.mentorship;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDao {
    public CategoryDao() {
    }

    public synchronized void delete(int id) throws SQLException, ClassNotFoundException {
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

    public synchronized void insert(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("INSERT INTO category (name) VALUES (?)");
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized List<Map<String, Object>> listAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement selectStatement = conn.prepareStatement("SELECT * FROM category");
        ResultSet result = selectStatement.executeQuery();
        List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();
        while (result.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", result.getInt("id"));
            map.put("name", result.getString("name"));
            map.put("parent_id", result.getInt("parent_id"));
            categories.add(map);
        }
        selectStatement.close();
        return categories;
    }
}
