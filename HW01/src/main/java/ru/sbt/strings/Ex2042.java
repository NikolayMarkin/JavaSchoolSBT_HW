package ru.sbt.strings;

import java.util.Scanner;

public class Ex2042 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputLine = scanner.nextLine();
        String pattern = scanner.nextLine();

        int i = 0;
        while (i <= inputLine.length() - pattern.length()) {
            String substr = inputLine.substring(i, i + pattern.length());
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) != '?' && substr.charAt(j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.print(i + 1 + " ");
            }
            i++;
        }
    }
}
