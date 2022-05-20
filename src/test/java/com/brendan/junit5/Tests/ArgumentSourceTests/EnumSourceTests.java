package com.brendan.junit5.Tests.ArgumentSourceTests;

import com.brendan.junit5.Enums.Levels;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceTests {

    @ParameterizedTest
    @EnumSource(Month.class) // inbuilt enum source
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @ParameterizedTest
    @EnumSource(Levels.class) // custom enum source
    void getValuesFromCustomEnum(Levels level) {
        System.out.println(level.toString());
    }

    @ParameterizedTest
    @EnumSource(
            value = Levels.class,
            names = "MEDIUM",
            mode = EnumSource.Mode.INCLUDE)
    void getValuesFromCustomEnum_GetValue(Levels levels) {
        assertAll(
                "Level enum assertions group",
                () -> assertThat(levels.level.toString(), containsString("This")),
                () -> assertThat(levels.level.toString(), containsString("is")),
                () -> assertThat(levels.level.toString(), containsString("the")),
                () -> assertThat(levels.level.toString(), containsString("default"))
        );
    }
}
