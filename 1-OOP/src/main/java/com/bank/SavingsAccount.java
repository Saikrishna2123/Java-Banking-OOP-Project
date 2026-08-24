package com.bank;

public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 500;

    public SavingsAccount(int accountNumber,
                          String accountHolder,
                          double balance) {

        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid amount.");
            return;
        }

        if (getBalance() - amount >= MINIMUM_BALANCE) {

            deductBalance(amount);

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println(
                    "Withdrawal failed. Minimum balance of ₹500 must be maintained."
            );
        }
    }

    @Override
    public String getAccountType() {

        return "Savings Account";
    }
}