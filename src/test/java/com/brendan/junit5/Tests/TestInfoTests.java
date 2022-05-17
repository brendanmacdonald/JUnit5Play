package com.brendan.junit5.Tests;

import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.logging.Logger;


public class TestInfoTests {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        logger.info(() -> String.format("This is the beforeEach() for test: " + testInfo.getTestMethod().get().getName()));
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        logger.info(() -> String.format("This is the afterEach() for test: " + testInfo.getTestMethod().get().getName()));
    }

    @Test
    void testOne() {}

    @Test
    void testTwo() {}
}
