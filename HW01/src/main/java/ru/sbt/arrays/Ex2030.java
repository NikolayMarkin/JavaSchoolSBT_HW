package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2030 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int countPair = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                if (sum == 0) {
                    countPair++;
                }
            }
        }

        System.out.println(countPair);
    }
}
