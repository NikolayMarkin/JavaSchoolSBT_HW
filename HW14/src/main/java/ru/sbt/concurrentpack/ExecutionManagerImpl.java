package ru.sbt.concurrentpack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionManagerImpl implements ExecutionManager {

    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        List<Future<?>> list = new ArrayList<>();
        for (Runnable task : tasks) {
            list.add(threadPool.submit(task));
        }

        return new ContextImpl(list);
    }
}
