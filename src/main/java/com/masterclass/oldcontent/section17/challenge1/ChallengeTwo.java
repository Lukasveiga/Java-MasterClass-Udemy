package com.masterclass.oldcontent.section17.challenge1;

import java.util.function.Function;

public class ChallengeTwo {

    public static void main(String[] args) {

        Function<String, String> lambda = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar(lambda, "1234567890"));

    }

    public static String everySecondChar(Function<String, String> function, String source) {
        return function.apply(source);
    }

}
