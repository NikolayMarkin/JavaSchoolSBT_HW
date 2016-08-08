package ru.sbt.terminal;

import ru.sbt.terminal.exceptions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TerminalImpl implements Terminal {

    private static final int MAX_COUNT_OF_WRONG = 3;
    private static final long LOCK_TIME_IN_MS = 5 * 1000;

    private final TerminalServer server;
    private final Validator validator;

    private boolean correctPIN;
    private boolean accountLocked = false;
    private int countOfWrong = 0;
    private Date unlockTime;

    public TerminalImpl(TerminalServer server, Validator validator) {
        this.server = server;
        this.validator = validator;
    }

    @Override
    public boolean startSession(String accountNumber) {
        try {
            validator.validateAccount(accountNumber);
            server.startSession(accountNumber);
            System.out.println("Терминал: Ожидание ввода PIN-кода...");
            return true;
        } catch (WrongUserInputException | AccountNotFoundException e) {
            System.out.println("Терминал: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean enterPin(String pin) {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
            }
            validator.validatePin(pin);
            server.checkPIN(pin);

            correctPIN = true;
            countOfWrong = 0;
            System.out.println("Терминал: Корректный PIN");
            return true;
        } catch (WrongUserInputException | AccountIsLockedException e) {
            System.out.println("Терминал: " + e.getMessage());
        } catch (WrongPinException e) {
            countOfWrong++;
            System.out.println("Терминал: " + e.getMessage());
            if (countOfWrong >= MAX_COUNT_OF_WRONG) {
                accountLocked = true;
                unlockTime = new Date(System.currentTimeMillis() + LOCK_TIME_IN_MS);
                System.out.println("Терминал: Счет заблокирован до: " + getUnlockTimeFormatted());
            }
        }
        return false;
    }

    @Override
    public void getAccountBalance() {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
            }
            if (!correctPIN) {
                throw new PINNotEnteredException("Необходимо ввести PIN-код");
            }

            int balance = server.getAccountBalance();
            System.out.println("Терминал: Текущий остаток на счете: " + balance);
        } catch (AccountIsLockedException | PINNotEnteredException e) {
            System.out.println("Терминал: " + e.getMessage());
        }
    }

    @Override
    public void getCash(int sum) {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
            }
            if (!correctPIN) {
                throw new PINNotEnteredException("Необходимо ввести PIN-код");
            }
            if (sum % 100 != 0) {
                throw new WrongCashSumException("Сумма для снятия должна быть кратна 100");
            }

            int balance = server.getCash(sum);
            System.out.println("Терминал: Выдано " + sum + ". Остаток на счете: " + balance);
        } catch (WrongCashSumException | TerminalServerException | AccountIsLockedException | PINNotEnteredException e) {
            System.out.println("Терминал: " + e.getMessage());
        }
    }

    @Override
    public void putCash(int sum) {
        try {
            if (accountIsLocked()) {
                throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
            }
            if (!correctPIN) {
                throw new PINNotEnteredException("Необходимо ввести PIN-код");
            }
            if (sum % 100 != 0) {
                throw new WrongCashSumException("Сумма для внесения на счет должна быть кратна 100");
            }
            int balance = server.putCash(sum);
            System.out.println("Терминал: Внесено " + sum + ". Остаток на счете: " + balance);
        }catch (AccountIsLockedException | WrongCashSumException | TerminalServerException e) {
            System.out.println("Терминал: " + e.getMessage());
        }
    }

    @Override
    public void stopSession() {
        server.closeSession();
        System.out.println("Терминал: сеанс облуживания завершен");
    }

    private String getUnlockTimeFormatted() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(unlockTime);
    }

    private boolean accountIsLocked() {
        if (accountLocked) {
            if (unlockTime.compareTo(new Date(System.currentTimeMillis())) > 0) {
                return accountLocked;
            } else {
                accountLocked = false;
            }
        }
        return accountLocked;
    }
}
