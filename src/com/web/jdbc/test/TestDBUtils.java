package com.web.jdbc.test;

import com.web.domain.Account;
import com.web.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by lhl28 on 2018/1/25.
 */
public class TestDBUtils {
    //²åÈë
    @Test
    public void testAddUser(){

        try {
            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

            String sql =  "insert into account values(?,?)";
            Object[] params = {1,123};
            int row = queryRunner.update(sql,params);
            if(row>0){
                System.out.print("success");
            }else {
                System.out.print("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //¸üÐÂ
    @Test
    public void testUpdateUser(){

        try {
            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
            String sql =  "update account set balance =? where accountid=?";
            Object[] params = {456,2};
            int row = queryRunner.update(sql,params);
            if(row>0){
                System.out.print("success");
            }else {
                System.out.print("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testQueryUser(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from account";
        try {
            List<Account> accounts = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
            for(Account account : accounts){
                System.out.println(account.getAccountid()+":"+account.getBalance());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
