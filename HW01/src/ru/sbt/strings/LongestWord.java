package ru.sbt.strings;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestWord {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputText = scanner.nextLine();
        int longerLength = 0;

        String pattern = "([a-zA-Z]+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputText);
        while(m.find()){
            longerLength = longerLength < m.group().length() ? m.group().length():  longerLength;
        }

        System.out.println(longerLength);
    }
}
