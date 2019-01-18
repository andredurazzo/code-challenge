package com.adurazzo.codeChallenge.commons;

import com.adurazzo.codeChallenge.exceptions.ValidationException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

public class Validator {

    public static <T> void checkNotNull(T reference, String message) {
        if (reference == null) {
            throw new ValidationException(message);
        }
    }

    public static <T> void checkNull(T reference, String message) {
        if (reference != null) {
            throw new ValidationException(message);
        }
    }

    public static void checkNotEmpty(String value, String message) {
        if (value.trim().length() <= 0) {
            throw new ValidationException(message);
        }
    }

    public static void checkNotNullOrEmpty(String value, String message) {
        checkNotNull(value, message);
        checkNotEmpty(value, message);
    }

    public static void checkNotNullOrEmpty(Collection collection, String message) {
        if (!(collection != null && !collection.isEmpty())) {
            throw new ValidationException(message);
        }
    }

    public static void checkState(Boolean state, String message) {
        if (!state) {
            throw new ValidationException(message);
        }
    }

    public static <T> void acceptOnlyValues(T reference, List<T> list, String message) {
        if (!list.contains(reference)) {
            throw new ValidationException(message);
        }
    }

    public static <T> void notAcceptOnlyValues(T reference, List<T> list, String message) {
        if (list.contains(reference)) {
            throw new ValidationException(message);
        }
    }

    public static void checkDatePattern(String date, String pattern, String message) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            throw new ValidationException(message);
        }
    }

    public static void  checkMinLength(String str, int minLength, String message) {
        if(str != null && str.length() < minLength)
            throw new ValidationException(message);
    }

    public static void  checkMaxLength(String str, int maxLength, String message) {
        if(str != null && str.length() > maxLength)
            throw new ValidationException(message);
    }
}