package ru.sbt.concurrentpack;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
