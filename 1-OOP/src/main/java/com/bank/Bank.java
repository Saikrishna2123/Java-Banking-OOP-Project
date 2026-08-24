package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {

        accounts = new ArrayList<>();
    }

    // Create account
    public void addAccount(Account account) {

        accounts.add(account);

        System.out.println(
                "Account created successfully!"
        );
    }

    // Find account
    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber()
                    == accountNumber) {

                return account;
            }
        }

        return null;
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println(
                    "No accounts available."
            );

            return;
        }

        for (Account account : accounts) {

            account.displayAccount();
        }
    }
}