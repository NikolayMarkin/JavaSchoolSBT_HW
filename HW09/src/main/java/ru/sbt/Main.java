package ru.sbt;

import ru.sbt.cacheproxy.CacheProxy;
import ru.sbt.services.Calculator;
import ru.sbt.services.CalculatorImpl;
import ru.sbt.services.ListGenerator;
import ru.sbt.services.ListGeneratorImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator proxyCalculator = CacheProxy.cache(new CalculatorImpl(),
                "C:/Data/java_projects/JavaSchoolSBT_HW/HW09");

        System.out.println(proxyCalculator.calc("name1", 2, 3));
        System.out.println(proxyCalculator.calc("name1", 2, 4));
        System.out.println(proxyCalculator.calc("name1", 5, 3));
        System.out.println(proxyCalculator.calc("name3", 1, 1));

        ListGenerator listGenerator = CacheProxy.cache(new ListGeneratorImpl(),
                "C:/Data/java_projects/JavaSchoolSBT_HW/HW09");
        List<Integer> list = listGenerator.generate(1_000_000);

        System.out.println(list);
    }
}
