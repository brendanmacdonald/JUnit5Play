package com.brendan.junit5.Tests.ArgumentSourceTests;

import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NullAndEmptySourceTests {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

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
        assertTrue(string == null || (string.isEmpty() && string.isBlank()));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void alternativeToUsingNullOrEmptySourceAnnotations(String string) {
        logger.info(() -> String.format("String is set to the value: ***" + string + "***"));
    }
}
