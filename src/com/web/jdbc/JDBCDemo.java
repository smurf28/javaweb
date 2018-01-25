package com.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lhl28 on 2018/1/25.
 */
public class JDBCDemo {
    public static void main(String []args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql:///bookstore","root","root");
            //¿ªÆôÊÂÎï
            connection.setAutoCommit(false);

            Statement statement =  connection.createStatement();
            statement.executeQuery("insert into account VALUE (3, 234)");
            //
            connection.commit();
            statement.close();
            connection.close();
        } catch (Exception e) {
            try {
                //
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
