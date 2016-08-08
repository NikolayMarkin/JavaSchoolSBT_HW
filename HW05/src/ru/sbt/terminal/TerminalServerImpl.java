package ru.sbt.terminal;

import ru.sbt.terminal.exceptions.*;

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
                return;
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
        return curAccount.getBalance();
    }

    @Override
    public int getCash(int sum) {
        try {
            return curAccount.getCash(sum);
        } catch (InsufficientFundsException e){
            throw new TerminalServerException("Сервер: ошибка счета: " + e.getMessage(), e);
        }
    }

    @Override
    public int putCash(int sum) {
        return curAccount.putCash(sum);
    }

    @Override
    public void closeSession() {
        curAccount = null;
    }
}
