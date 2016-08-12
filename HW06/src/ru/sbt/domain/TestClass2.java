package ru.sbt.domain;

public class TestClass2 {
    private Number intField;
    private String strField;
    private Number doubleField;

    public TestClass2() {
    }

    public TestClass2(Number intField, String strField, Number doubleField) {
        this.intField = intField;
        this.strField = strField;
        this.doubleField = doubleField;
    }

    public void setIntField(Number intField) {
        this.intField = intField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public void setDoubleField(Number doubleField) {
        this.doubleField = doubleField;
    }

    public Number getIntField() {

        return intField;
    }

    public String getStrField() {
        return strField;
    }

    public Number getDoubleField() {
        return doubleField;
    }
}
