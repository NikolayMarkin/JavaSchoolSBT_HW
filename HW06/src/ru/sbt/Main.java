package ru.sbt;

import ru.sbt.domain.TestClassWithConsts;
import ru.sbt.reflections.Utils;

public class Main {
    public static void main(String[] args) {
        Utils.checkStringConstNameConvention(new TestClassWithConsts());
    }
}
