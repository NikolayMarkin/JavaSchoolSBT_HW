package ru.sbt.net.domain;

import java.io.Serializable;

public class Response implements Serializable {
    private final Object result;
    private final Throwable exception;

    public Response(Object result, Throwable exception) {
        this.result = result;
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public Throwable getException() {
        return exception;
    }
}
