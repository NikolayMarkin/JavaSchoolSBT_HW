package ru.sbt.cycles;

import java.util.Scanner;

public class RoundNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int grade = 0;

        while ((n & 1) == 0) {
            n >>= 1;
            grade++;
        }

        System.out.println(grade);
    }
}
