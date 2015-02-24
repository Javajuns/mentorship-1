package com.github.javamentorship.mentorship;
import java.sql.*;
public class DBImpl {

    //Start Methods for update and select query
    // Execute Update type commands for query
    public synchronized static int update(String query) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        Statement stmt = conn.createStatement();
        System.out.println(query);
        int result = stmt.executeUpdate(query);
        return result;

    }

    public synchronized static void update(String name, int parentId, int id) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        PreparedStatement updateStmt = null;
        String updateString = "UPDATE category SET name = ?, parent_id = ? WHERE id = ?";
        updateStmt = conn.prepareStatement(updateString);
        updateStmt.setString(1, name);
        updateStmt.setInt(2, parentId);
        updateStmt.setInt(3, id);
        updateStmt.executeUpdate();
    }

    // Execute Select type commands for query
    public synchronized static ResultSet select(String query) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        Statement stmt = conn.createStatement();
        System.out.println(query);
        ResultSet result = stmt.executeQuery(query);
        return result;
    }
    //End Methods for update and select query

}
