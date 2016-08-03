package ru.sbt.store.storeexceptions;

public class DbException extends StoreException {
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }
}
