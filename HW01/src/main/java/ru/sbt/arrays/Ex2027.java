package ru.sbt.arrays;

import java.util.Scanner;

public class Ex2027 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int lengthOfArray = scanner.nextInt();
        int[] a = fillArray(lengthOfArray);

        int l1 = scanner.nextInt() - 1;
        int r1 = scanner.nextInt() - 1;
        int l2 = scanner.nextInt() - 1;
        int r2 = scanner.nextInt() - 1;

        reverseArray(a, l1, r1);
        reverseArray(a, l2, r2);

        for(int e: a){
            System.out.print(e + " ");
        }
    }

    public static int[] fillArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return  array;
    }

    public static void reverseArray(int[] ar, int l, int r){
//        for (int i = l; l < l + r / 2; i++) {
//            int tmp = ar[i];
//            ar[i] = ar[r - j];
//            ar[r - j] = tmp;
//        }
//        for (int i = l, j = 0; i < l + r / 2 - ((r - l) % 2 ); j++, i++){
//            int tmp = ar[i];
//            ar[i] = ar[r - j];
//            ar[r - j] = tmp;
//        }
    }
}