package ru.sbt.executionmanager;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}