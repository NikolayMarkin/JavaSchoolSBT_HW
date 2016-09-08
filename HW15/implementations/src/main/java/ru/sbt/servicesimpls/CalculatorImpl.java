package ru.sbt.servicesimpls;

import ru.sbt.services.Calculator;

public class CalculatorImpl implements Calculator {
    public double calculate(Integer a1, Integer a2) {
        return a1 / a2 + 42;
    }
}
