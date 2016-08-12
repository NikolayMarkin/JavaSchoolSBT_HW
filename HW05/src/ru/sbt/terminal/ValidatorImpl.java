package ru.sbt.terminal;

import ru.sbt.terminal.Validator;
import ru.sbt.terminal.exceptions.WrongUserInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {

    @Override
    public void validateAccount(String accountNumber) {
        Pattern p = Pattern.compile("^[0-9]{5}$");
        Matcher matcher = p.matcher(accountNumber);
        if (accountNumber.length() != 5 || !matcher.matches()) {
            throw new WrongUserInputException("Номер счета должен состоять из 5 цифр");
        }
    }

    @Override
    public void validatePin(String pin) {
        Pattern p = Pattern.compile("^[0-9]{4}$");
        Matcher matcher = p.matcher(pin);
        if (pin.length() != 4 || !matcher.matches()) {
            throw new WrongUserInputException("Пин-код должен состоять из 4 цифр");
        }
    }
}
