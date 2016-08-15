package ru.sbt.cycles;

import java.util.Scanner;

public class FirstMinimum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // входная последовательность содержит значения от -10000 до 10000
        int minVal = 10001;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int curVal = scanner.nextInt();
            if (curVal < minVal) {
                index = i;
                minVal = curVal;
            }
        }

        System.out.println(index);
    }
}
