package ru.sbt.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountOfWords {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inputText = scanner.nextLine();

        String pattern = "([a-zA-Z]+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputText);
        int count = 0;
        while(m.find()){
            m.group();
            count++;
        }

        System.out.println(count);
    }
}
