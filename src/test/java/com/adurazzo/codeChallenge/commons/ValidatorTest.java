package com.adurazzo.codeChallenge.commons;

import com.adurazzo.codeChallenge.exceptions.ValidationException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ValidatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    public void should_throw_if_val_is_lower_than_expected() {
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("aMessage");

        Validator.checkMinLength("", 1, "aMessage");
    }

    public void should_not_throw_if_null() {
        Validator.checkMinLength(null, 1, "aMessage");
    }

    public  void should_not_throw_if_string_length_is_great_or_equal_to_min() {
        Validator.checkMinLength("1", 1, "aMessage");
        Validator.checkMinLength("1123123123", 5, "aMessage");
    }
}
