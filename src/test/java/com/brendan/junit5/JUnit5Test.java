package com.brendan.junit5;


import com.brendan.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Test {

    private Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5})
    @DisplayName("An example of a ValueSource parameterised test")
    void outputSumOfNumbersWithValueSource(int x) {
        String s = String.format("The square of %s should be " + (x*x), x);

        int actualSquare = calculator.squareNumber(x);
        assertEquals(x*x, actualSquare, s);
    }

    @ParameterizedTest(name = "{index} => int1={0}, int2={1}, sum={2}")
    @CsvSource({
            "2, 3, 5",
            "5, 4, 9"
    })
    @DisplayName("An example of a CsvSource parameterised test")
    void outputSumOfNumbersWithCSVSource(int x, int y, int expectedSum) {
        String s = String.format("The sum of %s and %s should be %s.", x, y, expectedSum);

        int actualSum = calculator.addNumbers(x, y);
        assertEquals(expectedSum, actualSum, s);
    }
}
