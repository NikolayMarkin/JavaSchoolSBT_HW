package ru.sbt;

import ru.sbt.models.Person;
import ru.sbt.streams.MyStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        List<Person> collection = new ArrayList<>();
        collection.add(new Person("Nick", 25));
        collection.add(new Person("Max", 23));
        collection.add(new Person("Andrew", 24));

        Map<String, Person> stringPersonMap = MyStream.of(collection)
                .filter(p -> p.getAge() < 25)
                .transform(p -> new Person(p.getName(), p.getAge() + 15))
                .toMap(p -> p.getName(), p -> p);

        System.out.println(stringPersonMap);
    }
}
