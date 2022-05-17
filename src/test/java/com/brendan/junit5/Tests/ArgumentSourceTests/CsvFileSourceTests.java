package com.brendan.junit5.Tests.ArgumentSourceTests;

import com.brendan.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileSourceTests {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "{index} => int1={0}, int2={1}, sum={2}")
    @CsvFileSource(resources = "/ints.csv", numLinesToSkip = 1)
    @DisplayName("An example of a CsvFileSource test")
    void outputSumOfNumbersWithCsvFileSource(int x, int y, int expectedSum) {
        String s = String.format("The sum of %s and %s should be %s.", x, y, expectedSum);

        int actualSum = calculator.addNumbers(x, y);
        assertEquals(expectedSum, actualSum, s);
    }
}
