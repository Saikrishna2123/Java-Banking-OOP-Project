package com.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        while (true) {

            System.out.println();
            System.out.println("==============================");
            System.out.println("     BANKING MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Update Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print(
                            "Enter account holder name: "
                    );

                    String holder =
                            scanner.nextLine();

                    System.out.print(
                            "Enter account type (Savings/Current): "
                    );

                    String type =
                            scanner.nextLine();

                    System.out.print(
                            "Enter initial balance: "
                    );

                    double balance =
                            scanner.nextDouble();

                    Account account =
                            new Account(
                                    holder,
                                    type,
                                    balance
                            );

                    bank.createAccount(account);

                    break;


                case 2:

                    System.out.print(
                            "Enter account ID: "
                    );

                    int id =
                            scanner.nextInt();

                    bank.viewAccount(id);

                    break;


                case 3:

                    bank.viewAllAccounts();

                    break;


                case 4:

                    System.out.print(
                            "Enter account ID: "
                    );

                    int updateId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter new account holder name: "
                    );

                    String newHolder =
                            scanner.nextLine();

                    System.out.print(
                            "Enter new account type: "
                    );

                    String newType =
                            scanner.nextLine();

                    System.out.print(
                            "Enter new balance: "
                    );

                    double newBalance =
                            scanner.nextDouble();

                    Account updatedAccount =
                            new Account(
                                    updateId,
                                    newHolder,
                                    newType,
                                    newBalance
                            );

                    bank.updateAccount(
                            updatedAccount
                    );

                    break;


                case 5:

                    System.out.print(
                            "Enter account ID: "
                    );

                    int deleteId =
                            scanner.nextInt();

                    bank.deleteAccount(deleteId);

                    break;


                case 6:

                    System.out.println(
                            "Thank you for using the Banking System."
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }
}