package com.github.javamentorship.mentorship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {
    public synchronized static void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = null;
        String updateString = "UPDATE category SET name = ?, parent_id = ? WHERE id = ?";
        updateStmt = conn.prepareStatement(updateString);
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
        updateStmt.close();
        conn.close();
    }

    public synchronized static void insert(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        String updateString = "INSERT INTO category (name) VALUES (?)";
        PreparedStatement updateStmt = conn.prepareStatement(updateString);
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
        conn.close();
    }

    public static List<Map<String, Object>> listAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = DBImpl.select("SELECT * FROM category");
        List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", String.valueOf(rs.getInt("id"))); //TODO integer
            map.put("name", rs.getString("name"));
            map.put("parentId", String.valueOf(rs.getInt("parent_id"))); //TODO Integer
            categories.add(map);
        }
        return categories;
    }
}
