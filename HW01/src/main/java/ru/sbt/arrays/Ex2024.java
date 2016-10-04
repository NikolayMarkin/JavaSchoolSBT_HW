package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2024 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int countOfElemForChange = 0;


        for (int i = 0; i < n / 2; i++) {
            if (array[i] != array[n - i - 1]) {
                countOfElemForChange++;
            }

        }
        System.out.println(countOfElemForChange);
    }
}
