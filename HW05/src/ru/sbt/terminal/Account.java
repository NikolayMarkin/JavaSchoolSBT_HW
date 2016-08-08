package ru.sbt.terminal;

import ru.sbt.terminal.exceptions.InsufficientFundsException;

public class Account {
    private final String accountNumber;
    private final String pin;
    private int balance;

    public Account(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public int putCash(int cash) {
        balance += cash;
        return balance;
    }

    public int getCash(int cash) {
        if (cash > balance) {
            throw new InsufficientFundsException("Не достаточно средств для снятия такой суммы");
        }
        balance -= cash;
        return balance;
    }
}
