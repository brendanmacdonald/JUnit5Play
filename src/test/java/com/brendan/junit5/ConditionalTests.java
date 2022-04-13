package com.brendan.junit5;

import com.brendan.junit5.CustomConditions.RunOnWindowsOsVersion10;
import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.*;

import java.util.logging.Logger;

public class ConditionalTests {

    private static final Logger logger = Logger.getLogger(LoggingExtension.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        logger.info(() -> String.format("Preparing to start test: " + testInfo.getTestMethod().get().getName()));

        // Output system properties.
        System.getProperties().forEach((key, value) -> System.out.println(key+" - "+value));

        // Output system environment variables.
        System.getenv().forEach((key, value) -> System.out.println(key+" - "+value));
    }

    @Test
    @Disabled
    void disabledTestOne() {
    }

    @Test
    @DisabledOnOs(OS.MAC)
    void disabledTestTwo() {
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void enabledTestOne() {
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void enabledTestTwo() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERDOMAIN", matches = ".*BOOK*")
    void enabledTestThree() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.version", matches = ".*10.0.*")
    void enabledTestFour() {
    }

    @RunOnWindowsOsVersion10 // a custom condition
    void enabledTestFive() {}
}
