package ru.sbt.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int min = 101;

        List<Integer> listOfIndex = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (array[i] < min) {
                min = array[i];
                listOfIndex.clear();
            }
            if (array[i] == min) {
                listOfIndex.add(i + 1);
            }
        }

        int countOfMin = listOfIndex.size();
        int middle =  countOfMin % 2 == 0 ? countOfMin / 2 : (countOfMin + 1) / 2;

        System.out.println(listOfIndex.get(middle - 1));
    }
}
