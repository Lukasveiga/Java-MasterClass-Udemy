package com.masterclass.oldcontent.section18.challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeTwo {

    public static void main(String[] args) {

        String challenge1 = "abcd.135uvqz.7tzik.999";

        Pattern pattern = Pattern.compile("\\w+.(\\d+)");
        Matcher matcher = pattern.matcher(challenge1);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        String challenge2 = "abcd.135\tuvqz.7\tzik.999\n";
        pattern = Pattern.compile("\\w+.(\\d+)\\s");
        matcher = pattern.matcher(challenge2);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.printf("Occurrence: %03d; Count:%2d; %d to %d%n", Integer.valueOf(matcher.group(1)), count, matcher.start(1), (matcher.end(1)-1));
        }

        String challenge3 = "{0,2},{0,5}, {1,3}, {2,4}";
        pattern = Pattern.compile("\\{(\\d+,\\d+)}");
        matcher = pattern.matcher(challenge3);

        while (matcher.find()) {
            System.out.println("Occurrence: " + matcher.group(1));
        }
    }
}
