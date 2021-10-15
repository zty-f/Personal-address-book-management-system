package com.wei.pims.util;

import java.sql.*;

public class DBUtils {
    public static String username;
    public static String password;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            username = "root";
            password = "123456";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact?useSSL=false", username, password);
        return conn;
    }

    public static PreparedStatement getPStamt(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) throws Exception {
        if (rs != null)
            rs.close();
    }

    public static void close(Connection connection) throws Exception {
        if (connection != null)
            connection.close();
    }

    public static void close(PreparedStatement ps) throws Exception {
        if (ps != null) {
            ps.close();
        }
    }

    public static boolean insert(String sql, String... objects) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = DBUtils.getPStamt(conn, sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setString(i + 1, objects[i]);
            }
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                DBUtils.close(ps);
                DBUtils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static PreparedStatement setPreparedStatementParams(PreparedStatement ps, Object[] args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }
}