package ru.sbt.cycles;

import java.util.Scanner;

public class Ex2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        /*
        01
        02 03
        04 05 06
        07 08 09 10
        11 12 13 14 15
        ...
         */
        int rackNum = 0;
        int countOfBooks = 0;

        while (countOfBooks < n) {
            rackNum++;
            countOfBooks += rackNum;
        }

        System.out.println(rackNum);


    }
}
