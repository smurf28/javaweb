package com.web.domain;

/**
 * Created by lhl28 on 2018/1/25.
 */
public class Account {
//    SELECT accountid, balance
//    FROM `bookstore`.`account`;
    private int accountid;
    private int balance;
    public Account(){}

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
