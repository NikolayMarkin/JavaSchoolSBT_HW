package ru.sbt;

import ru.sbt.store.DataBaseStore;
import ru.sbt.store.Db;
import ru.sbt.store.DbImpl;
import ru.sbt.store.Store;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try (Db db = new DbImpl()) {
            Store store = new DataBaseStore(db);

            store.getAll();

        } catch (Exception ignore) {
        }
    }
}
