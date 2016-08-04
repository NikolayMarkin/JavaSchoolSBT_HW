package ru.sbt;

import ru.sbt.terminal.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        try (Db db = new DbImpl()) {
//            Store store = new DataBaseStore(db);
//
//            store.getAll();
//
//        } catch (Exception ignore) {
//            ignore.printStackTrace();
//        }

//        Validator validator = new ValidatorImpl();
//        validator.validateAccount("10001");
//        validator.validatePin("123");
////        validator.validateAccount("100");
//        validator.validateAccount("10000");


        Terminal terminal = new TerminalImpl(new TerminalServerImpl(), new ValidatorImpl());
        if (terminal.startSession("10001"))
        {
            terminal.enterPin("1234");
        }




    }
}
