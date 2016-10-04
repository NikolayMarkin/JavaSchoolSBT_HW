package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int max = getMax(array);
        divItems(array, max);
        max = getMax(array);
        divItems(array, max);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int getMax(int[] array) {
        int max = 0;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static void divItems(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                array[i] /= 2;
            }
        }
    }
}
