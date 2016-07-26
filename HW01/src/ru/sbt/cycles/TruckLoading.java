package ru.sbt.cycles;

import java.util.Scanner;

/**
 * Created by Nikolay on 26.07.2016.
 */
public class TruckLoading {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int w = scanner.nextInt();

        int count = 0;
        int sum = 0;

        for (int i = 0; i < n; i++){
            int nextItem = scanner.nextInt();
            if (sum + nextItem <= w) {
                sum += nextItem;
                count++;
            }
        }

        System.out.println(count + " " + sum);
    }
}
