package com.brendan.junit5;


import com.brendan.calculator.Calculator;
import com.brendan.junit5.Extensions.LoggingExtension;
import com.brendan.junit5.Extensions.TimingExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueSourceTests {

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        System.out.println("After each test method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5})
    @DisplayName("An example of a ValueSource parameterised test")
    @ExtendWith({TimingExtension.class, LoggingExtension.class})
    void outputSumOfNumbersWithValueSource(int x) throws InterruptedException {
        String s = String.format("The square of %s should be " + (x*x), x);

        // Enforce sleep to test timing extension.
        Thread.sleep(1500);

        int actualSquare = calculator.squareNumber(x);
        assertEquals(x*x, actualSquare, s);
    }
}
