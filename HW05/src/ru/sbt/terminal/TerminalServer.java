package ru.sbt.terminal;

public interface TerminalServer {

    void startSession(String accountNumber);

    void checkPIN(String PIN);

    int getAccountBalance();

    int getCash(int sum);

    int putCash(int sum);

    void closeSession();

}
