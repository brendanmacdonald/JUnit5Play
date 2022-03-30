package com.brendan.junit5;

import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.logging.Logger;

public class TagTests {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());


    @Test
    @Tag("smoke")
    void tagTestOne(TestInfo testInfo) {
        logger.info(() -> String.format("The tags on this test are: " + testInfo.getTags()));
    }

    @Test
    @Tag("smoke")
    @Tag("regression")
    void tagTestTwo(TestInfo testInfo) {
        logger.info(() -> String.format("The tags on this test are: " + testInfo.getTags()));
    }

    @Test
    @Tag("regression")
    void tagTestThree(TestInfo testInfo) {
        logger.info(() -> String.format("The tags on this test are: " + testInfo.getTags()));
    }

    @Test
    @Tag("development")
    void tagTestFour(TestInfo testInfo) {
        logger.info(() -> String.format("The tags on this test are: " + testInfo.getTags()));
    }
}
