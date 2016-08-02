package ru.sbt.cycles;

import java.util.Scanner;

/**
 * Created by oti on 22.07.2016.
 */
public class Bissextile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
    }
}
