package ru.sbt.cycles;

import java.util.Scanner;

public class CountOfMinItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int coutnOfMinItems = 0;
        int minItem = 10001;

        for (int i = 0; i < n; i++) {
            int curItem = scanner.nextInt();
            if (curItem < minItem) {
                minItem = curItem;
                coutnOfMinItems = 0;
            }
            if (curItem == minItem) {
                coutnOfMinItems++;
            }
        }

        System.out.println(coutnOfMinItems);
    }
}
