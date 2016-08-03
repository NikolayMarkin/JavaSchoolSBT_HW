package ru.sbt.store;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbImpl implements Db {
    List<String> db = new ArrayList<String>();
    @Override
    public void insert(String line) throws SQLException {
        if (line.length() > 25){
            throw new SQLException("Сохраняемая строка не может быть длиннее 25 символов");
        }
        db.add(line);
    }

    @Override
    public List<String> selectAll() throws SQLException {
        if (db.size() == 0){
            throw new SQLException("В хранилище нет данных");
        }
        return new ArrayList<String>(db);
    }

    @Override
    public void close() {
        System.out.println("Close");
    }
}
