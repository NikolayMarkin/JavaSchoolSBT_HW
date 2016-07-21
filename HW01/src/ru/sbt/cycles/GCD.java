package ru.sbt.cycles;

import java.util.Scanner;

/**
 * Created by oti on 21.07.2016.
 */
public class GCD {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int countOfSubtract = 0;

        while ( m > 0 && n > 0 ) {
            if (m > n) {
                m -= n;
            }
            else {
                n -= m;
            }
            countOfSubtract++;
        }

        int gcd = m > n ? m : n;

        System.out.println(countOfSubtract + " " + gcd);
    }

    public static int gcd(int m, int n){
        if (n == 0){
            return m;
        }
        return gcd(n, m % n);
    }
}
