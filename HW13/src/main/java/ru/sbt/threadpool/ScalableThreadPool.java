package ru.sbt.threadpool;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class ScalableThreadPool implements ThreadPool {
    private final Object lock = new Object();
    private final int minNumOfThreads;
    private final int maxNumOfThreads;
    private final TaskQueue tasks = new TaskQueue();

    private volatile int numOfActiveWorkers;

    private final HashSet<Worker> workers = new HashSet<>();

    public ScalableThreadPool(int minNumOfThreads, int maxNumOfThreads) {
        this.minNumOfThreads = minNumOfThreads;
        this.maxNumOfThreads = maxNumOfThreads;
    }

    @Override
    public void start() {
        for (int i = 0; i < minNumOfThreads; i++) {
            createAndStartWorker();
        }
    }

    private void createAndStartWorker() {
        Worker w = new Worker();
        workers.add(w);
        w.start();
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (lock) {
            tasks.add(runnable);

            lock.notify();
        }
    }

    private class TaskQueue {
        private final Queue<Runnable> tasks = new ArrayDeque<>();

        public void add(Runnable task) {
            tasks.add(task);

            if (tasks.size() > 1 && numOfActiveWorkers < maxNumOfThreads) {
                createAndStartWorker();
            }
        }

        public Runnable poll() {
            Runnable task = tasks.poll();
            if (tasks.size() == 1 && numOfActiveWorkers > minNumOfThreads + 1) {
                // удалить один 
            }
            return task;
        }

        public boolean isEmpty() {
            return tasks.isEmpty();
        }

        public int size() {
            return tasks.size();
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
                    numOfActiveWorkers++;
                }

                execute(task);
                numOfActiveWorkers--;
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
