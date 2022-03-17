package com.brendan.junit5;

import com.brendan.junit5.Extensions.RandomNumberExtension;
import com.brendan.junit5.Extensions.RandomStringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTests {

    @Test
    @ExtendWith(RandomStringExtension.class)
    void assertLengthOfRandomStringFromExtension(String string) {
        System.out.println("x is " + string);
        assertEquals(string.length(), 10, "The randomly generated string was not 10 characters long.");
    }

    @Test
    @ExtendWith(RandomNumberExtension.class)
    void assertRandomNumberFromExtension(Integer integer) {
        System.out.println("x is " + integer);
        assertTrue(integer <= 10, "The random integer was not less than 10.");
    }
}
