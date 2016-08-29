package ru.sbt.tasks;

public class RuntimeExecutionException extends RuntimeException {
    public RuntimeExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
