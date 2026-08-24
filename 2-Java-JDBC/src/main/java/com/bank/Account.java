package com.bank;

public class Account {

    private int accountId;
    private String accountHolder;
    private String accountType;
    private double balance;

    public Account() {
    }

    public Account(int accountId,
                   String accountHolder,
                   String accountType,
                   double balance) {

        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account(String accountHolder,
                   String accountType,
                   double balance) {

        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccount() {

        System.out.println("----------------------------");
        System.out.println("Account ID     : " + accountId);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("----------------------------");
    }
}