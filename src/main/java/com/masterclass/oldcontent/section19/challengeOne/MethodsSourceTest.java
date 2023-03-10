package com.masterclass.oldcontent.section19.challengeOne;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MethodsSourceTest {

    private static Stream<Arguments> everyNthCharTestProvider() {
        final char[] source = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        return Stream.of(
                Arguments.of(source, source, 0),
                Arguments.of(source, source, 1),
                Arguments.of(new char[]{'b', 'd', 'f'}, source, 2),
                Arguments.of(new char[]{'c', 'f'}, source, 3),
                Arguments.of(new char[]{'d'}, source, 4),
                Arguments.of(new char[]{'e'}, source, 5),
                Arguments.of(new char[]{'f'}, source, 6),
                Arguments.of(new char[]{'g'}, source, 7),
                Arguments.of(source, source, 8)
        );
    }

    private static Stream<Arguments> removePairsTestProvider() {
        return Stream.of(
                Arguments.of("abcdef", "aabcddeff"),
                Arguments.of("GEFTR", "GGEEFFTTRR"),
                Arguments.of("abcabdef", "abccabdeff"),
                Arguments.of("opTHg", "ooppTtTHHGg"),
                Arguments.of("", ""),
                Arguments.of(null, null)

        );
    }

    private static Stream<Arguments> converterTestPovider(){
        return Stream.of(
                Arguments.of(658, 22, 23),
                Arguments.of(328, 11, 14),
                Arguments.of(298, 10, 63),
                Arguments.of(1500, 50, 18),
                Arguments.of(2000, 66, 3),
                Arguments.of(2701, 90, 28),
                Arguments.of(750, 25, 11),
                Arguments.of(2879, 96, 93),
                Arguments.of(238, 8, 51),
                Arguments.of(1980, 66, 33)
        );
    }

    private static Stream<Arguments> nullIfOddLengthTestProvider(){
        return Stream.of(
                Arguments.of(null, "jav"),
                Arguments.of("java", "java"),
                Arguments.of(null, "javat"),
                Arguments.of("javate", "javate"),
                Arguments.of(null, "javates"),
                Arguments.of("javatest", "javatest")
        );
    }
}
