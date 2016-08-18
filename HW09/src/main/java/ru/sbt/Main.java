package ru.sbt;

import ru.sbt.cacheproxy.CacheProxy;
import ru.sbt.services.Calculator;
import ru.sbt.services.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        Calculator proxyCalculator = CacheProxy.cache(new CalculatorImpl());

        System.out.println(proxyCalculator.calc(2, 3));
        System.out.println(proxyCalculator.calc(2, 4));
        System.out.println(proxyCalculator.calc(2, 3));
    }
}
