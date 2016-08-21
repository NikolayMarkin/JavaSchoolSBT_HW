package ru.sbt.services;

import java.util.ArrayList;
import java.util.List;

public class ListGeneratorImpl implements ListGenerator {

    @Override
    public List<Integer> generate(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < count; i++) {
            list.add(i);
        }
        return list;
    }
}
