package com.bank;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountHolder,
                          double balance) {

        super(accountHolder, "Savings", balance);
    }
}