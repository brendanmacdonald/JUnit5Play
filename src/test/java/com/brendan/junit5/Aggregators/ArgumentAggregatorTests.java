package com.brendan.junit5.Aggregators;

import com.brendan.junit5.TestObjects.Person;
import com.brendan.junit5.Tests.ArgumentAggregatorTests.PersonAggregator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentAggregatorTests {

    @ParameterizedTest
    @CsvSource({"Isaac Newton,Isaac,,Newton", "Charles Robert Darwin,Charles,Robert,Darwin"})
    void fullName_ShouldGenerateTheExpectedFullName(String expectedFullName, @AggregateWith(PersonAggregator.class) Person person) {
        assertEquals(expectedFullName, person.fullName());
    }
}
