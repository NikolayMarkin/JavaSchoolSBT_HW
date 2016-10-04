package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        int countOfPair = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (array[i] % array[j] == 0)) {
                    countOfPair++;
                }
            }
        }
        System.out.println(countOfPair);
    }
}
