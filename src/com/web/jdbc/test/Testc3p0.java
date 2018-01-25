package com.web.jdbc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.web.jdbc.utils.C3P0Utils;
import com.web.jdbc.utils.JDBCUtils_V3;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by lhl28 on 2018/1/24.
 */
public class Testc3p0 {
    @Test
    public void testAddUser(){
        Connection connection = null;
        PreparedStatement pstmt = null;

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            connection = dataSource.getConnection();
            String sql = "insert into account values(?,?)";
            //重写这个方法
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,4);
            pstmt.setInt(2,123);
            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.print("success!");
            }else
                System.out.print("error!");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils_V3.release(connection,pstmt,null);
        }
    }

    @Test
    public void testAddUser1(){
        Connection connection = null;
        PreparedStatement pstmt = null;


        try {
            connection = C3P0Utils.getConnection();
            String sql = "insert into account values(?,?)";
            //重写这个方法
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,2);
            pstmt.setInt(2,123);
            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.print("success!");
            }else
                System.out.print("error!");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtils_V3.release(connection,pstmt,null);
        }
    }
}
