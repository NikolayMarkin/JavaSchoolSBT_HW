package ru.sbt.executionmanager;

public class Barrier {
    private final int nThread;
    private int currentThread;

    public Barrier(int nThread) {
        this.nThread = nThread;
    }

    public synchronized void await() {
        while (currentThread < nThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void countDown() {
        if (++currentThread == nThread) {
            notifyAll();
            return;
        }
    }
}
