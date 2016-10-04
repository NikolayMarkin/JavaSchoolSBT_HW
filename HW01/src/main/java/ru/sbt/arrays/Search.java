package ru.sbt.arrays;

import java.util.Scanner;

public class Search {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] a = new int[100000];
        int[] b = new int[100000];
        int[] c = new int[100000];

        int lengthOfArrayA = scanner.nextInt();
        fillArray(lengthOfArrayA, a);

        int lengthOfArrayB = scanner.nextInt();
        fillArray(lengthOfArrayB, b);

        int indexC = 0;

        for (int i = 0; i < lengthOfArrayA; i++) {
            for(int j = 0; j < lengthOfArrayB; j++) {
                if (a[i] == b[j]){
                    c[indexC++] = a[i];
                    // элемент уже есть в итоговом массиве
                    a[i] = -1;
                }
            }
        }

        System.out.println(indexC);
        for(int i = 0; i < indexC; i++){
            System.out.print(c[i] + " ");
        }
    }

    public static void fillArray(int length, int[] array) {
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
    }



}
