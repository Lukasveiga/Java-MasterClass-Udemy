package com.masterclass.oldcontent.section19.challengeOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities utilities;

    @BeforeEach
    void setup(){
        utilities = new Utilities();
    }

    @ParameterizedTest
    @MethodSource("com.masterclass.section19.challengeOne.MethodsSourceTest#everyNthCharTestProvider")
    void everyNthCharTest(char[] expected, char[] sourceCharArray, int n) {
        assertArrayEquals(expected, utilities.everyNthChar(sourceCharArray, n));
    }

    @ParameterizedTest
    @MethodSource("com.masterclass.section19.challengeOne.MethodsSourceTest#removePairsTestProvider")
    void removePairsTest(String expected, String source) {
        assertEquals(expected, utilities.removePairs(source));
    }

    @ParameterizedTest
    @MethodSource("com.masterclass.section19.challengeOne.MethodsSourceTest#converterTestPovider")
    void converterTest(int expected, int a, int b) {
        assertEquals(expected, utilities.converter(a, b));
        
    }
    
    @Test
    void converterTestArithmeticException(){
        assertThrows(ArithmeticException.class, () -> utilities.converter(10,0));
    }

    @ParameterizedTest
    @MethodSource("com.masterclass.section19.challengeOne.MethodsSourceTest#nullIfOddLengthTestProvider")
    void nullIfOddLengthTest(Object expected, String source) {
        assertEquals(expected, utilities.nullIfOddLength(source));
    }
}