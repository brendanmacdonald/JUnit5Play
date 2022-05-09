package com.brendan.junit5;

import com.brendan.calculator.Calculator;
import com.brendan.junit5.Extensions.LoggingExtension;
import com.brendan.junit5.Extensions.TimingExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TimingExtension.class)
public class CsvSourceTests {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "{index} => int1={0}, int2={1}, sum={2}")
    @CsvSource({
            "2, 3, 5",
            "5, 4, 9"
    })
    @DisplayName("An example of a CsvSource parameterised test")
    @ExtendWith({LoggingExtension.class})
    void outputSumOfNumbersWithCSVSource(int x, int y, int expectedSum) {
        String s = String.format("The sum of %s and %s should be %s.", x, y, expectedSum);

        int actualSum = calculator.addNumbers(x, y);
        assertEquals(expectedSum, actualSum, s);
    }
}
