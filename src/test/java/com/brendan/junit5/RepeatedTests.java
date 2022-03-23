package com.brendan.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTests {

    @RepeatedTest(
            value = 5,
            name = "{displayName}: repetition {currentRepetition} out of a total of {totalRepetitions}."
    )
    @DisplayName("Repeated test example")
    void repeatedTestExampleWithCustomName(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + "-->" + repInfo.getCurrentRepetition()
        );
    }

    @RepeatedTest(
            value = 5,
            name = RepeatedTest.LONG_DISPLAY_NAME
    )
    @DisplayName("Repeated test example")
    void repeatedTestExampleWithLongDisplayName(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + "-->" + repInfo.getCurrentRepetition()
        );
    }

    @RepeatedTest(
            value = 5
    )
    @DisplayName("Repeated test example")
    void repeatedTestExampleWithNoNameSupplied(RepetitionInfo repInfo, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName() + "-->" + repInfo.getCurrentRepetition()
        );
    }
}

