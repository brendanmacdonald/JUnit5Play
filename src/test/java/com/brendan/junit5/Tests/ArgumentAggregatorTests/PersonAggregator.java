package com.brendan.junit5.Tests.ArgumentAggregatorTests;

import com.brendan.junit5.TestObjects.Person;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class PersonAggregator implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new Person(
                argumentsAccessor.getString(1), argumentsAccessor.getString(2), argumentsAccessor.getString(3));
    }
}

