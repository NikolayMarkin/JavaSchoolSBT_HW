package ru.sbt.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2059 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scanner.nextInt();

        List<Integer> list = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            list.add(scanner.nextInt());
        }

        List<Integer> result = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            int next = findLeftItem(list, i, list.get(i));
            result.add(next);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static int findLeftItem(List<Integer> list, int index, int curVal) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            Integer item = list.get(i);
            if (item < min && item > curVal) {
                min = item;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
