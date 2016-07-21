package ru.sbt.cycles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikolay on 21.07.2016.
 */
public class SimpleNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < 2) {
            return;
        }

        List<Integer> simpleNums = new ArrayList<>();

        // со следующего простого числа
        simpleNums.add(2);
        for (int i = 3; i <= n; i = i + 2) {
            boolean isSimple = true;
            for(int  num : simpleNums){
                isSimple = i % num == 0 ? false : true;
                if (!isSimple){
                    break;
                }
            }
            if (isSimple) {
                simpleNums.add(i);
            }
        }

        for (int num : simpleNums) {
            System.out.println(num);
        }
    }
}
