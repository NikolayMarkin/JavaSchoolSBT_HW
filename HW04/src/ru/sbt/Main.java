package ru.sbt;

import ru.sbt.generics.CountMap;
import ru.sbt.generics.CountMapImpl;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        testCountMap();
    }

    static void testCountMap() {
        CountMap<Integer> countMap = new CountMapImpl<>();

        // тестируем вставку элементов
        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(5);
        countMap.add(0);

        if (countMap.getCount(10) == 2
                && countMap.getCount(5) == 3
                && countMap.getCount(6) == 1
                && countMap.getCount(0) == 1) {
            System.out.println("Количество элементов совпадает");
        } else {
            System.out.println("Ошибка! Количество вставленных элементов не совпадает");
        }

        if (countMap.size() == 4) {
            System.out.println("Количество различных элементов совпадает");
        } else {
            System.out.println("Ошибка! Количество различных элементов не совпадает");
        }

        // тестируем удаление элементов
        if (countMap.remove(5) == 3
                && countMap.remove(0) == 1
                && countMap.remove(-1) == 0) {
            System.out.println("Значение количества элементов до удаления корректно");
        } else {
            System.out.println("Ошибка! Значение количество элеменов до удаления некорректно");
        }

        if (countMap.getCount(5) == 2
                && countMap.getCount(0) == 0) {
            System.out.println("Количество элементов после удаления совпадает");
        } else {
            System.out.println("Ошибка! Количество элементов после удаления не совпадает");
        }

        // тестируем слияние двух коллекций
        CountMap<Integer> countMap1 = new CountMapImpl<>();
        CountMap<Integer> countMap2 = new CountMapImpl<>();

        countMap1.add(10);
        countMap1.add(5);
        countMap1.add(2);

        countMap2.add(10);
        countMap2.add(10);
        countMap2.add(5);
        countMap2.add(5);
        countMap2.add(5);
        countMap2.add(3);

        countMap1.addAll(countMap2);

        if (countMap1.getCount(10) == 3
                && countMap1.getCount(5) == 4
                && countMap1.getCount(2) == 1
                && countMap1.getCount(3) == 1) {
            System.out.println("Количество после слияния элементов совпадает");
        } else {
            System.out.println("Ошибка! Количество элементов после слияния не совпадает");
        }
    }
}
