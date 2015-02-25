package com.github.javamentorship.mentorship;
import java.sql.*;
public class DBImpl {

    //Start Methods for update and select query
    // Execute Update type commands for query
    @Deprecated
    public synchronized static int update(String query) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        Statement stmt = conn.createStatement();
        System.out.println(query);
        int result = stmt.executeUpdate(query);
        return result;

    }

    // Execute Select type commands for query
    @Deprecated
    public synchronized static ResultSet select(String query) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnectionPool.getConnection();
        Statement stmt = conn.createStatement();
        System.out.println(query);
        ResultSet result = stmt.executeQuery(query);
        return result;
    }
    //End Methods for update and select query

}
