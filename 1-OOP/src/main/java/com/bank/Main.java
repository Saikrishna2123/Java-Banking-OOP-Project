package com.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        boolean running = true;

        while (running) {

            System.out.println("\n===== BANKING SYSTEM =====");

            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Balance");
            System.out.println("6. View All Accounts");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                // CREATE SAVINGS ACCOUNT
                case 1:

                    System.out.print(
                            "Enter Account Number: "
                    );

                    int savingsNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Account Holder Name: "
                    );

                    String savingsName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Initial Balance: "
                    );

                    double savingsBalance =
                            scanner.nextDouble();

                    Account savingsAccount =
                            new SavingsAccount(
                                    savingsNumber,
                                    savingsName,
                                    savingsBalance
                            );

                    bank.addAccount(
                            savingsAccount
                    );

                    break;


                // CREATE CURRENT ACCOUNT
                case 2:

                    System.out.print(
                            "Enter Account Number: "
                    );

                    int currentNumber =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Account Holder Name: "
                    );

                    String currentName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Initial Balance: "
                    );

                    double currentBalance =
                            scanner.nextDouble();

                    System.out.print(
                            "Enter Overdraft Limit: "
                    );

                    double overdraftLimit =
                            scanner.nextDouble();

                    Account currentAccount =
                            new CurrentAccount(
                                    currentNumber,
                                    currentName,
                                    currentBalance,
                                    overdraftLimit
                            );

                    bank.addAccount(
                            currentAccount
                    );

                    break;


                // DEPOSIT
                case 3:

                    System.out.print(
                            "Enter Account Number: "
                    );

                    int depositAccountNumber =
                            scanner.nextInt();

                    Account depositAccount =
                            bank.findAccount(
                                    depositAccountNumber
                            );

                    if (depositAccount != null) {

                        System.out.print(
                                "Enter Deposit Amount: "
                        );

                        double amount =
                                scanner.nextDouble();

                        depositAccount.deposit(
                                amount
                        );

                    } else {

                        System.out.println(
                                "Account not found."
                        );
                    }

                    break;


                // WITHDRAW
                case 4:

                    System.out.print(
                            "Enter Account Number: "
                    );

                    int withdrawAccountNumber =
                            scanner.nextInt();

                    Account withdrawAccount =
                            bank.findAccount(
                                    withdrawAccountNumber
                            );

                    if (withdrawAccount != null) {

                        System.out.print(
                                "Enter Withdrawal Amount: "
                        );

                        double amount =
                                scanner.nextDouble();

                        withdrawAccount.withdraw(
                                amount
                        );

                    } else {

                        System.out.println(
                                "Account not found."
                        );
                    }

                    break;


                // VIEW BALANCE
                case 5:

                    System.out.print(
                            "Enter Account Number: "
                    );

                    int balanceAccountNumber =
                            scanner.nextInt();

                    Account balanceAccount =
                            bank.findAccount(
                                    balanceAccountNumber
                            );

                    if (balanceAccount != null) {

                        System.out.println(
                                "\nCurrent Balance: ₹" +
                                        balanceAccount.getBalance()
                        );

                    } else {

                        System.out.println(
                                "Account not found."
                        );
                    }

                    break;


                // VIEW ALL
                case 6:

                    bank.displayAllAccounts();

                    break;


                // EXIT
                case 7:

                    running = false;

                    System.out.println(
                            "Thank you for using the Banking System!"
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        scanner.close();
    }
}