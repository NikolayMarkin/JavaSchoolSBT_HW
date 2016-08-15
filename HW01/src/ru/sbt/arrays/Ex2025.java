package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int countOfRMQ = scanner.nextInt();

        for (int i = 0; i < countOfRMQ; i++) {
            int l = scanner.nextInt();
            int k = scanner.nextInt();

            int min = 101;
            for (int j = l - 1; j < k; j++) {
                if (array[j] < min ) {
                    min = array[j];
                }
            }
            System.out.println(min);
        }
    }

}
