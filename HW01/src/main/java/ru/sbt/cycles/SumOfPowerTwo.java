package ru.sbt.cycles;

import java.util.Scanner;

/**
 * Created by Nikolay on 26.07.2016.
 */
public class SumOfPowerTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nextIndex = 1;
        int sum = 0;

        for (int i = 1; i < n + 1; i++) {
            int nextItem = scanner.nextInt();
            if (i == nextIndex) {
                sum += nextItem;
                nextIndex *= 2;
            }
        }

        System.out.println(sum);
    }
}
