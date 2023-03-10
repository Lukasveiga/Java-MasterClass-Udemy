package com.masterclass.oldcontent.section18.challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeOne {

    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regExChallenge1 = "\\D \\D{4} \\D \\D{4}\\.";

        System.out.println("-------------- ");
        System.out.println(challenge1.matches(regExChallenge1) ? "Matches" : "Didn't matches");
        System.out.println(challenge2.matches(regExChallenge1) ? "Matches" : "Didn't matches");

        System.out.println("-------------- ");
        Pattern pattern = Pattern.compile(regExChallenge1);

        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches() ? "Matches" : "Didn't matches");

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches() ? "Matches" : "Didn't matches");

        System.out.println(" -------------- ");
        String challenge3 = "Replace all blanks with underscores.";
        System.out.println(challenge3.replaceAll("\s", "_"));

        System.out.println("-------------- ");
        String challenge4 = "aaabbcccccccddeeefffgg";
        System.out.println(challenge4.matches("[abcdefg]+") ? "Matches" : "Not matches");
        System.out.println(challenge4.matches("[a-g]+") ? "Matches" : "Not matches");

        System.out.println("-------------- ");
        String challenge5 = "abcd.135";
        String challenge6 = "kjisl.22";
        String challenge7 = "f5.12a";
        System.out.println(challenge5.matches("^\\w+\\.\\d+$") ? "Matches" : "Not matches");
        System.out.println(challenge6.matches("^\\w+\\.\\d+$") ? "Matches" : "Not matches");
        System.out.println(challenge7.matches("^\\w+\\.\\d+$") ? "Matches" : "Not matches");
    }
}
