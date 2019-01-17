package com.adurazzo.codeChallenge.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum RISK_TYPE {
    A(0), B(1), C(2);
    private final int id;

    RISK_TYPE(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

}