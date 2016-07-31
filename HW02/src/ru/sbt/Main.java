package ru.sbt;

import ru.sbt.model.Person;

public class Main {

    public static void main(String[] args) {
        Person john = new Person("John", true);
        Person julia = new Person("Julia", false);

        if (john.marry(julia)) {
            System.out.println("Новая семья создана");
            System.out.println(john);
            System.out.println(julia);
        } else {
            System.out.println("Что-то пошло не так...");
        }

        if (john.marry(julia)) {
            System.out.println("Ошибка! Удалось зарегистрировать брак дважды!");
        }

        Person bob = new Person("Robert", true);
        Person alice = new Person("Alice", false);

        System.out.println("Женим еще одну пару");
        bob.marry(alice);
        System.out.println(bob);
        System.out.println(alice);

        // всякое бывает, Джон полюбил Алису
        if (john.marry(alice)) {
            System.out.println("Новая семья на останках 2-х старых");
            System.out.println(john);
            System.out.println(julia);
            System.out.println(bob);
            System.out.println(alice);
        }

        if (john.marry(bob)) {
            System.out.println("Мир катится к чертям...");
        } else {
            System.out.println("В России однополые браки запрещены.");
            System.out.println(john);
            System.out.println(bob);
        }


        if (alice.divorce()) {
            System.out.println("Cемейная жизнь не заладилась, Алиса подала на развод");
            System.out.println(john);
            System.out.println(alice);
        }

        if (john.divorce()) {
            System.out.println("Джону удалось оформить еще один развод. Однако...");
        }

    }
}
