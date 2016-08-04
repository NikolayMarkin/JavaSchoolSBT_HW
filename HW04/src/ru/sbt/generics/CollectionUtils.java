package ru.sbt.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }


    public static <T> List<T> limit(List<T> source, int size) {
        return new ArrayList<T>(source.subList(0, size));
    }


    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }


    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }


    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        for (T item : c2) {
            if (!c1.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T item : c2) {
            if (c1.contains(item)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> List<T> range(List<T> list, T min, T max) {
        List<T> newList = new ArrayList<>(list);

        Collections.sort(newList);
        int indexOfMin = newList.indexOf(min);
        int indexOfMax = newList.lastIndexOf(max);

        return newList.subList(indexOfMin, indexOfMax);
    }


    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> newList = new ArrayList<>(list);

        Collections.sort(newList, comparator);
        int indexOfMin = newList.indexOf(min);
        int indexOfMax = newList.lastIndexOf(max);

        return newList.subList(indexOfMin, indexOfMax);
    }

}
