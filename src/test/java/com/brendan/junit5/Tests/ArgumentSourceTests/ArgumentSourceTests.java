package com.brendan.junit5.Tests.ArgumentSourceTests;

import com.brendan.junit5.ArgumentProviders.StringArgumentProvider;
import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.logging.Logger;

public class ArgumentSourceTests {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

    @ParameterizedTest
    @ArgumentsSource(StringArgumentProvider.class)
    void testUsingAnArgumentProvider(String argument) {
        logger.info(() -> String.format("ArgumentProvider supplied the string: " + argument));
    }
}
