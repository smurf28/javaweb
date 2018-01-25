package com.web.jdbc;

import com.web.jdbc.utils.JDBCUtils_V3;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by lhl28 on 2018/1/24.
 */
public class MyDataSource implements DataSource{
    //创建容器 存connection对象
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    //创建5个连接
    static {
        for(int i = 0 ;i<5;i++){
            Connection connection = JDBCUtils_V3.getConnection();
            pool.add(connection);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        if(pool.size()==0){
            for(int i = 0 ;i<5;i++){
                connection = JDBCUtils_V3.getConnection();
                MyConnection myConnection = new MyConnection(connection,pool);
                pool.add(myConnection);
            }
        }
        //获取链接对象
        connection = pool.remove(0);
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
