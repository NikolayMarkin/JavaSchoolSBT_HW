package ru.sbt.cycles;

import java.util.*;

public class Ex2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = a; i <= b; i++) {
            int countDivisor = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    countDivisor++;
                }
            }
            if (map.containsKey(countDivisor)){
                List<Integer> list = map.get(countDivisor);
                list.add(i);
                map.put(countDivisor, list);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(countDivisor, list);
            }
        }

        int max = Collections.max(map.keySet());

        System.out.println(map.get(max).size());
        StringBuilder builder = new StringBuilder();
        for (Integer item : map.get(max)) {
            builder.append(item);
            builder.append(',');
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}
