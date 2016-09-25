package ru.sbt.pingpong;

public class Gamer implements Runnable {
    private static Object lock = new Object();

    private final String name;

    public Gamer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("Поток прерван на очередной подаче");
                    return;
                }

                System.out.println(name);
                try {
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Поток прерван во время сна");
                    return;
                }
            }
        }
    }
}
