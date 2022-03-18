package com.brendan.junit5;

import com.brendan.junit5.Extensions.LoggingExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTests {

    private static StringBuilder output = new StringBuilder("");

    @Test
    @Order(1)
    @ExtendWith(LoggingExtension.class)
    public void firstTest() {
        output.append("A");
    }

    @Test
    @Order(3)
    @ExtendWith(LoggingExtension.class)
    public void thirdTest() {
        output.append("B");
    }

    @Test
    @Order(2)
    @ExtendWith(LoggingExtension.class)
    public void secondTest() {
        output.append("C");
    }

    @AfterAll
    public static void assertOutput() {
        assertEquals("ACB", output.toString());
    }
}
