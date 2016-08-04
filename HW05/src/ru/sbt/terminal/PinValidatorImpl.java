package ru.sbt.terminal;

public class PinValidatorImpl implements PinValidator{
    @Override
    public void validate(Account account, String pin) {
        if (!pin.equals(account.getPin())) {
            throw new RuntimeException("Некорректный пин");
        }
    }
}
