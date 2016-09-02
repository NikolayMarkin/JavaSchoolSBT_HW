package ru.sbt.threadpool;

import java.util.ArrayDeque;
import java.util.Queue;

public class FixedThreadPool implements ThreadPool {
    private final Object lock = new Object();
    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final int threadCount;
    private final Worker[] pool;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
        pool = new Worker[threadCount];
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCount; i++) {
            pool[i] = new Worker();
            pool[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (lock) {
            tasks.add(runnable);
            lock.notify();
        }
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) return;

                Runnable task;
                synchronized (lock) {
                    while (tasks.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    task = tasks.poll();
                }
                execute(task);
            }
        }

        private void execute(Runnable task) {
            if (task != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    writeInLog(e);
                }
            }
        }

        private void writeInLog(Exception e) {
            System.out.println(e);
        }
    }
}