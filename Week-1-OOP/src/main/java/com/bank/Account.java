package com.bank;

public abstract class Account {

    // Encapsulation
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber,
                   String accountHolder,
                   double balance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            System.out.println("₹" + amount +
                    " deposited successfully.");

        } else {

            System.out.println("Invalid amount.");
        }
    }

    // Child classes will implement this differently
    public abstract void withdraw(double amount);

    public abstract String getAccountType();

    // Used by child classes
    protected void deductBalance(double amount) {
        balance -= amount;
    }

    public void displayAccount() {

        System.out.println("\n------------------------");

        System.out.println("Account Number: " +
                accountNumber);

        System.out.println("Account Holder: " +
                accountHolder);

        System.out.println("Account Type: " +
                getAccountType());

        System.out.println("Balance: ₹" +
                balance);

        System.out.println("------------------------");
    }
}