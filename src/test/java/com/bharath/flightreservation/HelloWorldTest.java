package com.bharath.flightreservation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        assertEquals("Hello, World!", "Hello, World!");
    }

    @Test
    public void testHelloWorldNotNull() {
        String value = "Hello, World!";
        assertNotNull(value);
    }

    @Test
    public void testHelloWorldLength() {
        String value = "Hello, World!";
        assertEquals(13, value.length());
    }

    @Test
    public void testHelloWorldStartsWithHello() {
        String value = "Hello, World!";
        assertTrue(value.startsWith("Hello"));
    }

    @Test
    public void testHelloWorldContainsComma() {
        String value = "Hello, World!";
        assertTrue(value.contains(","));
    }
}