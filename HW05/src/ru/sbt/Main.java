package ru.sbt;

import ru.sbt.terminal.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = getTerminal();

        if (terminal.startSession("wrong account number")) {

        } else {
            if (terminal.startSession("10001")) {

                terminal.getAccountBalance();

                terminal.enterPin("wrong pin");

                terminal.enterPin("1235");
                terminal.enterPin("1235");
                terminal.enterPin("1235");

                terminal.getAccountBalance();

                // необходимо подождать когда счет разблокируется
                System.out.println("Ждем 3 секунды");
                Thread.sleep(3 * 1000);
                terminal.enterPin("1234");
                System.out.println("Ждем еще 2 секунды");
                Thread.sleep(3 * 1000);


                // корректный пин
                terminal.enterPin("1234");

                terminal.getAccountBalance();

                terminal.getCash(150);
                terminal.getCash(200);

                terminal.putCash(150);
                terminal.putCash(500);

                terminal.getCash(300);

                terminal.stopSession();
            }
        }
    }

    private static Terminal getTerminal() {
        return new TerminalImpl(new TerminalServerImpl(), new ValidatorImpl());
    }
}
