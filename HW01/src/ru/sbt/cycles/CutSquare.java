package ru.sbt.cycles;

import java.util.Scanner;

public class CutSquare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        if (a1 + a2 == b1 && b1 == b2){
            System.out.println("YES");
        }
        else if (b1 + b2 == a1 && a1 == a2) {
            System.out.println("YES");
        }
        else if (a1 + b2 == b1 && a2 == b1) {
            System.out.println("YES");
        }
        else if (a2 + b1 == a1 && a1 == b2) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}

