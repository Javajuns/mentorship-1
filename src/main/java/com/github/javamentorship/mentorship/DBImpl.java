package com.github.javamentorship.mentorship;
import java.sql.*;
public class DBImpl {

    //Start Methods for update and select query
    // Execute Update type commands for query
    public synchronized static int update(String query) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate(query);
        return result;

    }

    // Execute Select type commands for query
    public synchronized static ResultSet select(String query) throws SQLException, ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(query);
        return result;
    }
    //End Methods for update and select query

}
