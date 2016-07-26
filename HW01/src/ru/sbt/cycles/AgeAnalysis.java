package ru.sbt.cycles;


import java.util.Scanner;

public class AgeAnalysis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 7) {
            System.out.println("preschool child");
        } else if (n >= 7 && n <= 17) {
            System.out.println("schoolchild " + (n - 6));
        } else if (n >= 18 && n <= 22) {
            System.out.println("student " + (n - 17));
        } else {
            System.out.println("specialist");
        }
    }
}
