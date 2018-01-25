package com.web.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lhl28 on 2018/1/24.
 */
public class JDBCUtils_V3 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * ��̬�������������ļ���Ϣ
     */
    static {
        try {
            // 1.ͨ����ǰ���ȡ�������
            ClassLoader classLoader = JDBCUtils_V3.class.getClassLoader();
            // 2.ͨ����������ķ������һ��������
            InputStream is = classLoader.getResourceAsStream("db.properties");
            // 3.����һ��properties����
            Properties props = new Properties();
            // 4.����������
            props.load(is);
            // 5.��ȡ��ز�����ֵ
            /**
             * db_url      = jdbc:mysql://3306/bookstore?characterEncoding=utf-8
             db_driver   = com.mysql.jdbc.Driver
             db_username = root
             db_password = root
             *
             * */
            driver = props.getProperty("db_driver");
            url = props.getProperty("db_url");
            username = props.getProperty("db_username");
            password = props.getProperty("db_password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ȡ���ӷ���
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * �ͷ���Դ����
     *
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

