package ru.sbt.executionmanager;

import java.util.ArrayList;
import java.util.List;

public class ExecutionManagerImpl implements ExecutionManager {

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return new ThreadPool(callback, tasks);
    }

    private class ThreadPool implements Context {
        private final Runnable callback;
        private final List<Thread> threadPool;

        public ThreadPool(Runnable callback, Runnable... tasks) {
            this.callback = callback;
            threadPool = new ArrayList<>();
            for (Runnable task : tasks) {
                Thread newThread = new Thread(task);
                threadPool.add(newThread);
                newThread.start();
            }
        }

        @Override
        public int getCompletedTaskCount() {
            return 0;
        }

        @Override
        public int getFailedTaskCount() {
            return 0;
        }

        @Override
        public int getInterruptedTaskCount() {
            return 0;
        }

        @Override
        public void interrupt() {

        }

        @Override
        public boolean isFinished() {
            for (Thread thread : threadPool) {
                thread.getState();
            }
            return false;
        }
    }

}
