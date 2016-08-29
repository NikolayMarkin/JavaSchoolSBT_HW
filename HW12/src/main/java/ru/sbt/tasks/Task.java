package ru.sbt.tasks;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Object lock = new Object();

    private final Callable<? extends T> callable;

    private volatile T calculatedValue;
    private volatile RuntimeExecutionException ee;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        RuntimeExecutionException exception = ee;
        if (exception != null) {
            throw exception;
        }

        T result = calculatedValue;
        if (result == null) {
            synchronized (lock) {
                result = calculatedValue;
                if (result == null) {
                    System.out.println("Пытаемся получить результ работы Callable...");
                    try {
                        calculatedValue = result = callable.call();
                    } catch (Exception e) {
                        ee = new RuntimeExecutionException("Ошибка при выполнении задачи", e);
                        throw ee;
                    }
                }
            }
        }
        return result;
    }
}