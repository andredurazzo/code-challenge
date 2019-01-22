package com.adurazzo.codeChallenge.controller;

import com.adurazzo.codeChallenge.enums.RiskEnumStrategy;

public class CreditLimitPresenter {

    private String clientName;

    private Double creditLimit;

    private RiskEnumStrategy type;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public RiskEnumStrategy getType() {
        return type;
    }

    public void setType(RiskEnumStrategy type) {
        this.type = type;
    }
}
