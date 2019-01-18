package com.adurazzo.codeChallenge.model;


import com.adurazzo.codeChallenge.enums.RiskEnumStrategy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.adurazzo.codeChallenge.commons.Validator.*;

@Document(collection = "creditLimit")
public class CreditLimit {

    @Id
    private String id;

    @Indexed
    private String clientName;

    private Double creditLimit;

    private RiskEnumStrategy type;

    private Integer interestRate;

    private Double interestApplied;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Double getInterestApplied() {
        return interestApplied;
    }

    public void setInterestApplied(Double interestApplied) {

    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public void check() {
        checkNotNull(creditLimit, "Credit limit is required!");
        checkNotNullOrEmpty(clientName, "Client name is required!");
        checkNotNull(type, "Type is required!");

    }

    public void applyInterest(){
        this.interestRate  = this.type.getRate();
        this.interestApplied = this.type.execute(this.creditLimit);
    }
}
