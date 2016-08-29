package ru.sbt.tasks;


public class MainTestTask {
    public static void main(String[] args) {
        Task<String> task = new Task<>(() -> {
            Thread.sleep(1000);
            return "Test";
        });
        Runnable getCalcValue = () -> {
            System.out.println(task.get());
        };
        runThreads(getCalcValue);

        Task<String> task2 = new Task<>(() -> {
            throw new RuntimeException("Ошибка при выполнении задачи");
        });
        Runnable getCalcValue2 = () -> {
            System.out.println(task2.get());
        };
        runThreads(getCalcValue2);
    }

    private static void runThreads(Runnable runnable) {
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }

}