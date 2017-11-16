package com.fizzbuzz;

public enum Category {
    FIZZ(3, "3", "fizz"),
    BUZZ(5, "5", "buzz");

    private final int number;
    private final String value;
    private final String text;

    Category(int number, String value, String text) {
        this.number = number;
        this.value = value;
        this.text = text;
    }

    public int getNumber() {
        return this.number;
    }

    public String getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }
}
