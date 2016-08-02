package ru.sbt.cycles;

import java.util.Scanner;

public class Ex2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int sum = 0;

        int sign = 1;
        int blockLength = 1;
        int blockNumber = 1;
        for (int i = 0; i < n; i++) {
            int currentNum = scanner.nextInt();
            if (blockLength == 0) {
                // поменять знак
                sign *= -1;
                // увеличить номер блока
                blockNumber++;
                blockLength = blockNumber;
            }
            sum += sign * currentNum;
            blockLength--;
        }

        System.out.println(sum);
    }
}
