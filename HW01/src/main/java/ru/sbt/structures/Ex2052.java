package ru.sbt.structures;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2052 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int countOfNumbers = scanner.nextInt();
        int countOfOperations = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < countOfNumbers; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 0; i < countOfOperations; i++) {
            int index = scanner.nextInt();
            list = removeMembers(list, index);
        }

        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> removeMembers(List<Integer> list, int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % index != 0)
                result.add(list.get(i));
        }
        return result;
    }
}
