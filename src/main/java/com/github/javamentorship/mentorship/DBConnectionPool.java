package com.github.javamentorship.mentorship;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ivan on 24.02.2015.
 */
public class DBConnectionPool {

    public static final String HSQLDB = "org.hsqldb.jdbcDriver";
    public static final String URL = "jdbc:hsqldb:file:target/devDb/devDb";
    public static final String USER = "sa";
    public static final String PASS = "";
    private static Connection conn;

    private static void init() {
        try {
            Class.forName(HSQLDB);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (conn != null){
            return conn;
        } else {
            init();
            return conn;
        }
    }
}
