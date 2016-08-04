package ru.sbt.terminal;

public interface Terminal {
    boolean startSession(String accountNumber);

    boolean enterPin(String pin);

    void getAccountBalance();

    void getCash(int sum);

    void putCash(int sum);

    void stopSession();
}
