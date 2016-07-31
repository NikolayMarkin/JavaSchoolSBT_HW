package ru.sbt.collections;

import java.util.*;

public class Ex2056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.next().toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();

        List<String> mostPopularWords = new ArrayList<>();

        for (String word : words) {
            Integer count = map.get(word);
            count = count != null ? count : 0;
            map.put(word, ++count);
        }

        Integer max = Collections.max(map.values());

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (max.equals(item.getValue())){
                mostPopularWords.add(item.getKey());
            }
        }

        Collections.sort(mostPopularWords);

        for (String word : mostPopularWords) {
            System.out.println(word);
        }
    }
}
