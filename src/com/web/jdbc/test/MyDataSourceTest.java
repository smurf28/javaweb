package com.web.jdbc.test;

import com.web.jdbc.utils.JDBCUtils_V3;
import com.web.jdbc.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by lhl28 on 2018/1/24.
 */
public class MyDataSourceTest {
    private MyDataSource myDataSource;
    @org.junit.Test
    public void getConnection() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;

        MyDataSource dataSource = new MyDataSource();
        try {
            connection = dataSource.getConnection();
            String sql = "insert into account values(?,?)";
            //重写这个方法
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,3);
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