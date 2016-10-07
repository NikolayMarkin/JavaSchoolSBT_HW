package ru.sbt.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2053 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine().toLowerCase());
            builder.append('\n');
        }

        String inputText = builder.toString();


        String pattern = "([a-zA-Z]+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inputText);

        Map<String, Integer> keys = new HashMap<>();

        while(m.find()){
            if (keys.containsKey(m.group())) {
                System.out.print(keys.get(m.group()) + " ");
            }
            else {
                int newKey = keys.size() + 1;
                keys.put(m.group(), newKey);
                System.out.print(newKey + " ");
            }
        }
    }
}
