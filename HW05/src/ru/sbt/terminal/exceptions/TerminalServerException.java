package ru.sbt.terminal.exceptions;

public class TerminalServerException extends RuntimeException {
    public TerminalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
