package ru.sbt.arrays;

import java.util.*;


public class Ex2031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SortedMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int item = scanner.nextInt();
            if (map.containsKey(item)) {
                int count = map.get(item);
                map.put(item, count + 1);
            } else {
                map.put(item, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > 1) {
                list.add(item.getKey());
            }
        }

        System.out.println(list.size());
        for (Integer item : list) {
            System.out.print(item + " ");
        }
    }
}

