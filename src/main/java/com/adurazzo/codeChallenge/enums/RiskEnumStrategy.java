package com.adurazzo.codeChallenge.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum RiskEnumStrategy {

    TYPE_A(0) {
        @Override
        public Double execute(Double value) {
            return value;
        }
    },

    TYPE_B(10) {
        @Override
        public Double execute(Double value) {
            return (value * (TYPE_B.rate / 100)) + value;
        }
    },

    TYPE_C(20) {
        @Override
        public Double execute(Double value) {

            return (value * (TYPE_C.rate / 100)) + value;
        }
    };

    public abstract Double execute(Double value);

    private int rate;
    RiskEnumStrategy(int rate){
        this.rate = rate;
    }

    public int getRate(){
        return rate;
    }

}