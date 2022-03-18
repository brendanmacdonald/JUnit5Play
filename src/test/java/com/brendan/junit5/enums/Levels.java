package com.brendan.junit5.enums;

public enum Levels {
    LOW(""),
    MEDIUM ("This is the default."),
    HIGH("");

    Levels(String level) {
        this.level = level;
    }

    public final String level;
}
