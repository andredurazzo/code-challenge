package com.adurazzo.codeChallenge.exception;

public class CreditLimitNotFoundException extends RuntimeException {

    public CreditLimitNotFoundException(Long id) {
        super("Could not find credit limit:  " + id);
    }

    public CreditLimitNotFoundException(String name) {
        super("Could not find credit limit:  " + name);
    }
}