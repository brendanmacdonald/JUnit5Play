package com.brendan.junit5;


import com.brendan.calculator.Calculator;
import com.brendan.junit5.Interfaces.TimingAndLoggingTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComposedAnnotationTests {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5})
    @DisplayName("An example of a ValueSource parameterised test")
    @TimingAndLoggingTests
     void outputSumOfNumbersWithValueSourceAndComposedAnnotation(int x) throws InterruptedException {
        String s = String.format("The square of %s should be " + (x*x), x);

        // Enforce sleep to test timing extension.
        Thread.sleep(1500);

        int actualSquare = calculator.squareNumber(x);
        assertEquals(x*x, actualSquare, s);
    }
}
