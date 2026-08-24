package com.bank;

public class Bank {

    private AccountDAO accountDAO;

    public Bank() {
        accountDAO = new AccountDAO();
    }

    public void createAccount(Account account) {

        accountDAO.createAccount(account);
    }

    public void viewAccount(int accountId) {

        accountDAO.getAccount(accountId);
    }

    public void viewAllAccounts() {

        accountDAO.getAllAccounts();
    }

    public void updateAccount(Account account) {

        accountDAO.updateAccount(account);
    }

    public void deleteAccount(int accountId) {

        accountDAO.deleteAccount(accountId);
    }
}