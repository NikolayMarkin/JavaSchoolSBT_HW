package ru.sbt.pingpong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Gamer pinger = new Gamer("Ping");
        Gamer ponger = new Gamer("Pong");

        Thread thread1 = new Thread(pinger);
        Thread thread2 = new Thread(ponger);

        thread1.start();
        thread2.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread1.interrupt();
        thread2.interrupt();
    }
}
