package ru.sbt.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

    private final List<T> collection;

    private MyStream(List<? extends T> collection) {
        this.collection = new ArrayList<>(collection);
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<T>(list);
    }


    public MyStream<T> filter(Predicate<? super T> predicate) {
        for (Iterator<T> i = collection.iterator(); i.hasNext(); ) {
            T item = i.next();
            if (!predicate.test(item)) {
                i.remove();
            }
        }
        return this;
    }

    public MyStream<T> transform(Function<? super T, ? extends T> transformFun) {
        for (ListIterator<T> i = collection.listIterator(); i.hasNext(); ) {
            T transformedItem = transformFun.apply(i.next());
            i.set(transformedItem);
        }

        return this;
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyMapper,
                                  Function<? super T, ? extends V> valueMapper) {
        Map<K, V> map = new HashMap<>();

        for (T t : collection) {
            K key = keyMapper.apply(t);
            V value = valueMapper.apply(t);
            map.put(key, value);
        }
        return map;
    }
}
