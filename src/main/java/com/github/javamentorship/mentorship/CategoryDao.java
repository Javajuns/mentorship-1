package com.github.javamentorship.mentorship;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {
    public synchronized static void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = null;
        updateStmt = conn.prepareStatement("UPDATE category SET name = ?, parent_id = ? WHERE id = ?");
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized static void insert(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = conn.prepareStatement("INSERT INTO category (name) VALUES (?)");
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
    }

    public synchronized List<Map<String, Object>> listAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        Statement selectStatement = conn.createStatement();
        ResultSet result = selectStatement.executeQuery("SELECT * FROM category");
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
