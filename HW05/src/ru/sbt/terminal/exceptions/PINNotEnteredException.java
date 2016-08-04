package ru.sbt.terminal.exceptions;

public class PINNotEnteredException extends RuntimeException {
    public PINNotEnteredException(String message) {
        super(message);
    }
}
