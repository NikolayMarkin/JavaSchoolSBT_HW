package ru.sbt.terminal.exceptions;

public class WrongUserInputException extends RuntimeException {
    public WrongUserInputException(String message) {
        super(message);
    }
}
