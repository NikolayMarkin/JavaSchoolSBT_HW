package ru.sbt.terminal.exceptions;

public class WrongPinException extends RuntimeException {
    public WrongPinException(String message) {
        super(message);
    }
}
