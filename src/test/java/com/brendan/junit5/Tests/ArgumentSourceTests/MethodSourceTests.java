package com.brendan.junit5.Tests.ArgumentSourceTests;

import com.brendan.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MethodSourceTests {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "{index} => int1={0}, int2={1}, sum={2}")
    @MethodSource("intProvider")
    @DisplayName("An example of a CsvFileSource test")
    void outputSumOfNumbersWithMethodSource(int x, int y, int expectedSum) {
        String s = String.format("The sum of %s and %s should be %s.", x, y, expectedSum);

        int actualSum = calculator.addNumbers(x, y);
        assertEquals(expectedSum, actualSum, s);
    }

    static Stream<Arguments> intProvider() {
        return Stream.of(
                arguments(1,2,3),
                arguments(4,7,11));
    }
}
