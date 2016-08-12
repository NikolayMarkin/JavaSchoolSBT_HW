package ru.sbt.terminal;

public interface Validator {
    void validateAccount(String accountNumber);

    void validatePin(String pin);
}
