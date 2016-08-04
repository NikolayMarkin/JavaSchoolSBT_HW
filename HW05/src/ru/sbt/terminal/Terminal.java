package ru.sbt.terminal;

public interface Terminal {
    void startSession(String accountNumber);

    void enterPin(String pin);

    int getAccountBalance();

    int getCash(int sum);

    int putCash(int sum);

    void stopSession();
}
