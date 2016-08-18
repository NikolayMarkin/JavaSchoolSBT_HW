package ru.sbt.services;

import ru.sbt.cacheproxy.Cache;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int arg1, int arg2) {
        int res = 0;
        for (int i = 0; i < arg1; i++) {
            for (int j = 0; j < arg2; j++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                res += i * j;
            }
        }
        return res;
    }
}
