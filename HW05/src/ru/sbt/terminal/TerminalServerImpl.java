package ru.sbt.terminal;

import ru.sbt.terminal.exceptions.AccountNotFoundException;
import ru.sbt.terminal.exceptions.WrongPinException;
import ru.sbt.terminal.exceptions.WrongUserInputException;

import java.util.ArrayList;
import java.util.List;

public class TerminalServerImpl implements TerminalServer {
    private final List<Account> accountList;
    private Account curAccount;

    public TerminalServerImpl() {
        this.accountList = getStoredAccounts();
    }

    private List<Account> getStoredAccounts() {
        List<Account> list = new ArrayList<>();
        list.add(new Account("10001", "1234"));
        list.add(new Account("10002", "5678"));
        list.add(new Account("10003", "1278"));

        return list;

    }

    @Override
    public void startSession(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                curAccount = account;
            }
        }
        throw new AccountNotFoundException("Такой счет нe зарегистрирован");
    }

    @Override
    public void checkPIN(String PIN) {
        if (!curAccount.getPin().equals(PIN)) {
            throw new WrongPinException("Некорректный PIN");
        }
    }

    @Override
    public int getAccountBalance() {
        return 0;
    }

    @Override
    public int getCash(int sum) {
        return 0;
    }

    @Override
    public int putCash(int sum) {
        return 0;
    }

    @Override
    public void closeSession() {

    }
}
