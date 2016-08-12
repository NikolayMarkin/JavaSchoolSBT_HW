package ru.sbt.domain;

public class TestClass1 {
    private Integer intField;
    private String strField;
    private Double doubleField;

    public TestClass1() {
    }

    public TestClass1(Integer intField, String strField, Double doubleField) {
        this.intField = intField;
        this.strField = strField;
        this.doubleField = doubleField;
    }

    public Integer getIntField() {
        return intField;
    }

    public String getStrField() {
        return strField;
    }

    public Double getDoubleField() {
        return doubleField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public void setDoubleField(Double doubleField) {
        this.doubleField = doubleField;
    }
}
