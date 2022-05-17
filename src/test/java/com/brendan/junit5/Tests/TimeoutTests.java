package com.brendan.junit5.Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTests {

    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 2000)
    void timeoutTestOne() throws InterruptedException {
        // Enforce sleep to test timeout -> test should pass.
        Thread.sleep(1500);
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 1)
    void timeoutTestTwo() throws InterruptedException {
        // Enforce sleep to test timeout -> test should fail
        Thread.sleep(1500);
    }
}
