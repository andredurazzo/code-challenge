package com.adurazzo.codeChallenge.controller.advice;

import com.adurazzo.codeChallenge.exceptions.CreditLimitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class CreditLimitNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CreditLimitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CreditLimitNotFoundException ex) {
        return ex.getMessage();
    }
}
