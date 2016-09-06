package ru.sbt.concurrentpack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionManagerImpl implements ExecutionManager {

    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        CountDownLatch barrier = new CountDownLatch(tasks.length);
        List<Future<?>> list = new ArrayList<>();
        for (Runnable task : tasks) {
            list.add(threadPool.submit(() -> {
                try {
                    task.run();
                } catch (Exception e) {
                    writeInLog("Ошибка при выполнении задачи", e);

                } finally {
                    barrier.countDown();
                }
            }));
        }

        threadPool.submit(() -> {
            try{
                barrier.await();

                callback.run();
            } catch (InterruptedException e) {
                writeInLog("Поток для callback'a был прерван", e);
            } catch (Exception e) {
                writeInLog("Ошибка при выполнении callback'а", e);
            }
        });

        return new ContextImpl(list, barrier);
    }

    private void writeInLog(String message, Exception e) {
        System.out.println(message + e);
    }
}
