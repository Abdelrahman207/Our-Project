package com.store.dal.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    private static final String IP = "localhost";
    private static final String DB_NAME = "XE";
    private static final String SCHEMA_NAME = "stock_abdo";
    private static final String SCHEMA_PASSWORD = "stock_abdo";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@ " + IP + ":1521: " + DB_NAME, SCHEMA_NAME, SCHEMA_PASSWORD);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn == null) {
            return;
        } else {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closePreparedstatmen(PreparedStatement stmt) {
        if (stmt == null) {
            return;
        } else {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        } else {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
