package com.adurazzo.codeChallenge.model;

import com.adurazzo.codeChallenge.enums.RISK_TYPE;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "risk")
public class Risk {

    private RISK_TYPE type;

    private Long value;

    public RISK_TYPE getType() {
        return type;
    }

    public void setType(RISK_TYPE type) {
        this.type = type;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
