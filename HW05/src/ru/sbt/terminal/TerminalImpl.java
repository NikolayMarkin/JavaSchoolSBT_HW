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
    public void startSession(String accountNumber) {
        try {
            validator.validateAccount(accountNumber);
            server.startSession(accountNumber);
        } catch (WrongUserInputException e) {
            System.out.println(e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("Такого номера счета не существует");
        }
    }

    @Override
    public void enterPin(String pin) {
        try {
            validator.validatePin(pin);
            server.checkPIN(pin);

            correctPIN = true;
        } catch (WrongUserInputException e) {
            System.out.println(e.getMessage());
        } catch (WrongPinException e) {
            countOfWrong++;
            System.out.println(e.getMessage());
            if (countOfWrong > MAX_COUNT_OF_WRONG) {
                accountLocked = true;
                unlockTime = new Date(System.currentTimeMillis() + LOCK_TIME_IN_MS);
                throw new AccountIsLockedException("Счет заблокирован до: " + getUnlockTimeFormatted());
            }
        }
    }

    @Override
    public int getAccountBalance() {
        if (accountIsLocked()){
            throw new AccountIsLockedException("Счет заблокирован до:" + getUnlockTimeFormatted());
        }
        if (!correctPIN) {
            throw new PINNotEnteredException("Необходимо ввести PIN-код");
        }

        return server.getAccountBalance();
    }

    @Override
    public int getCash(int sum) {
        return 0;
    }

    @Override
    public int putCash(int sum) {
        return 0;
    }

    @Override
    public void stopSession() {
        

    }

    private String getUnlockTimeFormatted() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(unlockTime);
    }

    private boolean accountIsLocked() {
        if (accountLocked) {
            if (unlockTime.compareTo(new Date(System.currentTimeMillis())) > 0){
                return accountLocked;
            }
            else {
                accountLocked = false;
            }
        }
        return accountLocked;
    }
}
