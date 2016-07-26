package ru.sbt.cycles;

import java.util.Scanner;

/**
 * Created by oti on 21.07.2016.
 */
public class GCDHard {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int countOfSubtract = 0;

        while (m > 0 && n > 0) {

            if (m < n) {
                int tmp = m;
                m = n;
                n = tmp;
            }
            int howManyLonger = m / n;
            if (howManyLonger > 1) {
                m %= n;
                countOfSubtract += howManyLonger;
            } else {
                m -= n;
                countOfSubtract++;
            }
        }

        int gcd = m > n ? m : n;

        System.out.println(countOfSubtract + " " + gcd);
    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
}
