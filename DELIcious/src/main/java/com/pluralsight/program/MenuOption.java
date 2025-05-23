package com.pluralsight.program;

public enum MenuOption {
    HOME('0'),
    EXIT('X'),
    ORDER('O'),
    SANDWICH('S'),
    TOPPING('T'),
    DRINK('D'),
    CHIPS('C');

    private final char CODE;

    MenuOption(char code) {
        this.CODE = code;
    }

    public char getCODE() {
        return CODE;
    }
}
