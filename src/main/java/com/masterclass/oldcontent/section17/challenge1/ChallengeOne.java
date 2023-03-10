package com.masterclass.oldcontent.section17.challenge1;

import java.util.Arrays;

public class ChallengeOne {

    public static void main(String[] args) {

        Runnable runnable = () -> Arrays.stream("Let's split this up into an array".split(" "))
                .forEach(System.out::println);

        runnable.run();

    }
}
