package ru.sbt.concurrentpack;

public class MainExecutionManagerTest {
    public static void main(String[] args) {
        ExecutionManager manager = new ExecutionManagerImpl();

        Context context = manager.execute(() -> System.out.println("Все задачи выполнены"),
                () -> {
                    throw new RuntimeException("Исключительная ситуация при выполнении задачи");
                },
                () -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("2");
                },
                () -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("3");
                },
                () -> System.out.println("4"),
                () -> System.out.println("5"),
                () -> System.out.println("6"),
                () -> System.out.println("7"),
                () -> System.out.println("8"),
                () -> System.out.println("9")
        );


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
        context.interrupt();
        System.out.println("Количество прерванных задач: " + context.getInterruptedTaskCount());

        System.out.println("Количество задач, при выполнении которых произошло исключение: " + context.getFailedTaskCount());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Количество задач выполненных на данный момент:" + context.getCompletedTaskCount());
        System.out.println("Все задачи завершены? " + context.isFinished());

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("А теперь? " + context.isFinished());
    }
}