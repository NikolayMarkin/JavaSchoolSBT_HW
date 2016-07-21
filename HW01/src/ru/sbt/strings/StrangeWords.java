package ru.sbt.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrangeWords {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int count = Integer.parseInt(scanner.nextLine());
        String pattern = "[eyuioa]{3,}";
        Pattern p = Pattern.compile(pattern);

        String[] a = new String[count];

        for (int i = 0; i < count; i++) {
            String nextWord = scanner.nextLine();
            a[i] = nextWord;
        }
        for (int i = 0; i < count; i++) {

            Matcher m = p.matcher(a[i]);
            if (!m.find()) {
                System.out.println(a[i]);
            }

        }
    }
}
