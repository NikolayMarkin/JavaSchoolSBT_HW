package ru.sbt.generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {
    private final Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        int currentCount = this.getCount(elem);
        map.put(elem, ++currentCount);
    }

    @Override
    public int getCount(E elem) {
        Integer count = map.get(elem);
        return count != null ? count : 0;
    }

    @Override
    public int remove(E elem) {
        int currentCount = getCount(elem);
        if (currentCount == 1) {
            map.remove(elem);
        } else {
            map.put(elem, currentCount - 1);
        }
        return currentCount;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        Map<? extends E, Integer> src = source.toMap();
        for (Map.Entry<? extends E, Integer> entry : src.entrySet()) {
            int currentCount = this.getCount(entry.getKey());
            map.put(entry.getKey(), currentCount + entry.getValue());
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        Map<E, Integer> newMap = new HashMap<>();
        newMap.putAll(map);
        return newMap;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination.putAll(map);
    }
}
