package com.bank;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountHolder,
                          double balance) {

        super(accountHolder, "Current", balance);
    }
}