package com.masterclass.oldcontent.section19.challengeOne;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Utilities {

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n || n <= 0) {
            return sourceArray;
        }

        int returnLength = sourceArray.length / n;
        char[] result = new char[returnLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    public String removePairs(String source) {

        if (source == null || source.length() < 2) {
            return source;
        }

        CharacterIterator it = new StringCharacterIterator(source);

        StringBuilder sb = new StringBuilder();

        char currentChar;
        char nextChar;

        while (it.current() != CharacterIterator.DONE) {
            currentChar = it.current();
            nextChar = it.next();

            if (Character.toUpperCase(currentChar) != Character.toUpperCase(nextChar)) {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }

        return null;
    }

}
