package ru.sbt.concurrentpack;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ContextImpl implements Context {

    private final List<Future<?>> tasks;

    public ContextImpl(List<Future<?>> tasks) {
        this.tasks = tasks;
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
        for (Future<?> task : tasks) {
            if (!task.isDone()) {
                return false;
            }
        }
        return true;
    }
}
