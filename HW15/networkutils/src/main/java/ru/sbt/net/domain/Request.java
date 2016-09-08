package ru.sbt.net.domain;

import java.io.Serializable;

public class Request implements Serializable {
    private final String methodName;
    private final Object[] args;

    public Request(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = args;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getArgs() {
        return args;
    }
}
