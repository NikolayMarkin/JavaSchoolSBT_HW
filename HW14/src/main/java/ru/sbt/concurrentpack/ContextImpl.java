package ru.sbt.concurrentpack;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ContextImpl implements Context {

    private final List<Future<?>> tasks;
    private final CountDownLatch barrier;

    public ContextImpl(List<Future<?>> tasks, CountDownLatch barrier) {
        this.tasks = tasks;
        this.barrier = barrier;
    }

    @Override
    public int getCompletedTaskCount() {
        int count = 0;
        for (Future<?> task : tasks) {
            if (task.isDone()) {
                try {
                    task.get();
                    count++;
                } catch (InterruptedException | CancellationException | ExecutionException ignored) { }
            }
        }
        return count;
    }

    @Override
    public int getFailedTaskCount() {
        int count = 0;
        for (Future<?> task : tasks) {
            if(task.isDone()) {
                try {
                    task.get();
                } catch (InterruptedException | CancellationException ignore) {
                } catch (ExecutionException e) {
                   count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getInterruptedTaskCount() {
        int count = 0;
        for (Future<?> task : tasks) {
            if (task.isCancelled()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void interrupt() {
        for (Future<?> task : tasks) {
            task.cancel(false);
        }
    }

    @Override
    public boolean isFinished() {
        return barrier.getCount() == 0;
    }
}
