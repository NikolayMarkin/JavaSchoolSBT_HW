package ru.sbt.cycles;

import java.util.Scanner;

public class CountOfRootOfEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == 0 && b == 0 && c == 0) {
            System.out.println(-1);
            return;
        }

        if (a == 0 || (b == 0 && c == 0)) {
            System.out.println(1);
            return;
        }

        int discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            System.out.println(2);
        } else if (discriminant == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
