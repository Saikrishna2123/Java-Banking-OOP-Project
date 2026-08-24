package com.bank;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accountNumber,
                          String accountHolder,
                          double balance,
                          double overdraftLimit) {

        super(accountNumber, accountHolder, balance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {

            System.out.println("Invalid amount.");
            return;
        }

        if (getBalance() + overdraftLimit >= amount) {

            deductBalance(amount);

            System.out.println("Withdrawal successful.");

        } else {

            System.out.println(
                    "Withdrawal failed. Overdraft limit exceeded."
            );
        }
    }

    @Override
    public String getAccountType() {

        return "Current Account";
    }
}
