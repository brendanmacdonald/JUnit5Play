package com.brendan.junit5.Tests.ArgumentSourceTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NullAndEmptySourceTests {

    @ParameterizedTest
    @NullSource
    void returnTrueForNullInputs(String string) {
        assertTrue(string == null);
    }

    @ParameterizedTest
    @EmptySource
    void returnTrueForEmptyInputs(String string) {
        assertAll(
                () -> assertTrue(string.isEmpty()),
                () -> assertTrue(string.isBlank())
        );
    }

    @ParameterizedTest
    @NullAndEmptySource // This test will execute twice.
    void returnTrueForNullAndEmptyInputs(String string) {
        // do stuff
    }
}
