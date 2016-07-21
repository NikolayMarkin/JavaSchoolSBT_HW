package ru.sbt.arrays;

import java.util.Scanner;

public class Number04 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int lengthOfArray = scanner.nextInt();
        int[] a = fillArray(lengthOfArray);

        int[] countOfDigit = new int[5];

        for (int i = 0; i < lengthOfArray; i++) {
            countOfDigit[a[i]]++;
        }

        for (int i = 0; i < countOfDigit.length; i++) {
            if (countOfDigit[i] != 0) {
                System.out.println(i + " " + countOfDigit[i]);
            }
        }
    }

    public static int[] fillArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return  array;
    }

}
