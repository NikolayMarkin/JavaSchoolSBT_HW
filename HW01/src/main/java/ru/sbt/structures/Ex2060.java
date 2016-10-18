package ru.sbt.structures;

import java.util.*;

public class Ex2060 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int numOfRow = scanner.nextInt();

        Map<String, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < numOfRow; i++) {
            String studentName = scanner.next();
            int grade = scanner.nextInt();
            if (map.containsKey(studentName)) {
                List<Integer> gradeList = map.get(studentName);
                gradeList.add(grade);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(grade);
                map.put(studentName, list);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {

            List<Integer> gradeList = entry.getValue();
            int avg = 0;
            for (Integer grade : gradeList) {
                avg += grade;
            }
            System.out.println(entry.getKey() + " " + avg / gradeList.size());
        }
    }
}
