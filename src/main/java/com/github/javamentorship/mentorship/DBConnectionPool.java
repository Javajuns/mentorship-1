package com.github.javamentorship.mentorship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ivan on 24.02.2015.
 */
public class DBConnectionPool {

    private static Connection conn;

    private static void init() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:file:target/devDb/devDb", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (!conn=null){
            return conn;
        }
        else{
            this.init();
            return conn;
        }
    }
}
