package ru.sbt.threadpool;

/**
 * Created by oti on 01.09.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ScalableThreadPool(1, 3);

        pool.start();

        pool.execute(getNewTask(1000, 1));
        pool.execute(getNewTask(500, 2));
        pool.execute(getNewTask(500, 3));


        Thread.sleep(100);

        pool.execute(getNewTask(1000, 4));
        pool.execute(getNewTask(500, 5));
        pool.execute(getNewTask(500, 6));

    }

    private static Runnable getNewTask(int waitTime, int param) {
        return () -> {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(param);
        };
    }
}
