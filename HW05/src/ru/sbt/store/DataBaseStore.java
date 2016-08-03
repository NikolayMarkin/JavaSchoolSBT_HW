package ru.sbt.store;

import ru.sbt.store.storeexceptions.DbException;

import java.sql.SQLException;
import java.util.List;

public class DataBaseStore implements Store {

    private final Db db;

    public DataBaseStore(Db db) {
        this.db = db;
    }

    @Override
    public void save(String t) {
        try {
            db.insert(t);
        } catch (SQLException e) {
            throw new DbException("Ошибка при вставке данных", e);
        }
    }

    @Override
    public List<String> getAll() {
        try {
            return db.selectAll();
        } catch (SQLException e) {
            throw new DbException("Ошибка при получении данных", e);
        }
    }
}
