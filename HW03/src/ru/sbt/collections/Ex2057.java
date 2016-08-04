package ru.sbt.collections;

import java.util.*;

public class Ex2057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        TreeMap<Integer, Integer> multiset = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    int element = scanner.nextInt();
                    Integer count = multiset.get(element);
                    count = count != null ? count : 0;
                    multiset.put(element, ++count);
                    break;
                case 2:
                    Integer min = multiset.firstKey();
                    Integer countInSet = multiset.get(min);
                    if (countInSet - 1 == 0) {
                        multiset.remove(min);
                    }
                    else {
                        multiset.put(min, --countInSet);
                    }
                    System.out.println(min);
                    break;
            }
        }
    }
}
