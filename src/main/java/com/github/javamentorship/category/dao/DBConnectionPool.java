package com.github.javamentorship.category.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionPool {

    public static final String HSQLDB = "org.hsqldb.jdbcDriver";
    public static final String URL = "jdbc:hsqldb:file:target/devDb/devDb;ifexist=true";
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
            return null; //conn;
        } else {
            //init();
            return conn;
        }
    }
}
