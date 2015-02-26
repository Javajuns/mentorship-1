package com.github.javamentorship.mentorship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ivan on 24.02.2015.
 */
public class CategoryDao {
    public synchronized void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
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

    public synchronized void insert(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        PreparedStatement updateStmt = null;
        String updateString = "INSERT INTO category (name) VALUES (?)";
        updateStmt = conn.prepareStatement(updateString);
        updateStmt.setString(1, name);
        updateStmt.executeUpdate();
        updateStmt.close();
        conn.close();
    }
}
