package ru.sbt.cycles;

import java.util.Scanner;

public class Ex2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int counter = 0;
        int mostFreqValue = 0;
        int prevValue = 0;
        int curCounter = 0;
        int curItem = 0;

        for (int i = 0; i < n; i++) {
            curItem = scanner.nextInt();

            if (curItem != prevValue) {
                if (curCounter > counter) {
                    mostFreqValue = prevValue;
                    counter = curCounter;
                }
                prevValue = curItem;
                curCounter = 0;
            }


            curCounter++;
            if (curCounter > counter) {
                mostFreqValue = curItem;
                counter = curCounter;
            }
        }
        System.out.println(mostFreqValue + " " + counter);
    }
}
