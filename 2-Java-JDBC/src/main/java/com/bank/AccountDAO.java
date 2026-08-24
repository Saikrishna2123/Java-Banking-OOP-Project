package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    // CREATE
    public void createAccount(Account account) {

        String sql =
                "INSERT INTO accounts " +
                        "(account_holder, account_type, balance) " +
                        "VALUES (?, ?, ?)";

        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    account.getAccountHolder()
            );

            statement.setString(
                    2,
                    account.getAccountType()
            );

            statement.setDouble(
                    3,
                    account.getBalance()
            );

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Account created successfully."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Create error: " +
                            e.getMessage()
            );
        }
    }


    // READ - Single account
    public void getAccount(int accountId) {

        String sql =
                "SELECT * FROM accounts " +
                        "WHERE account_id = ?";

        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, accountId);

            try (ResultSet result =
                         statement.executeQuery()) {

                if (result.next()) {

                    Account account =
                            new Account(
                                    result.getInt("account_id"),
                                    result.getString(
                                            "account_holder"
                                    ),
                                    result.getString(
                                            "account_type"
                                    ),
                                    result.getDouble(
                                            "balance"
                                    )
                            );

                    account.displayAccount();

                } else {

                    System.out.println(
                            "Account not found."
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Read error: " +
                            e.getMessage()
            );
        }
    }


    // READ - All accounts
    public void getAllAccounts() {

        String sql =
                "SELECT * FROM accounts";

        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql);

             ResultSet result =
                     statement.executeQuery()) {

            boolean found = false;

            while (result.next()) {

                found = true;

                Account account =
                        new Account(
                                result.getInt("account_id"),
                                result.getString(
                                        "account_holder"
                                ),
                                result.getString(
                                        "account_type"
                                ),
                                result.getDouble(
                                        "balance"
                                )
                        );

                account.displayAccount();
            }

            if (!found) {

                System.out.println(
                        "No accounts found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Read error: " +
                            e.getMessage()
            );
        }
    }


    // UPDATE
    public void updateAccount(Account account) {

        String sql =
                "UPDATE accounts " +
                        "SET account_holder = ?, " +
                        "account_type = ?, " +
                        "balance = ? " +
                        "WHERE account_id = ?";

        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    account.getAccountHolder()
            );

            statement.setString(
                    2,
                    account.getAccountType()
            );

            statement.setDouble(
                    3,
                    account.getBalance()
            );

            statement.setInt(
                    4,
                    account.getAccountId()
            );

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Account updated successfully."
                );

            } else {

                System.out.println(
                        "Account not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Update error: " +
                            e.getMessage()
            );
        }
    }


    // DELETE
    public void deleteAccount(int accountId) {

        String sql =
                "DELETE FROM accounts " +
                        "WHERE account_id = ?";

        try (Connection connection =
                     DBConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, accountId);

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Account deleted successfully."
                );

            } else {

                System.out.println(
                        "Account not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Delete error: " +
                            e.getMessage()
            );
        }
    }
}