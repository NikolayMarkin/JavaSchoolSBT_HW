package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean wasReplaced = false;
            for (int j = i; j < n; j++) {
                if (array[j] > array[i]) {
                    array[i] = array[j];
                    wasReplaced = true;
                    break;
                }
            }
            if (!wasReplaced) {
                array[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

}