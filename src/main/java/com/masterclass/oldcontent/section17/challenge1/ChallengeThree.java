package com.masterclass.oldcontent.section17.challenge1;

import java.util.function.Supplier;

public class ChallengeThree {

    public static void main(String[] args) {

        Supplier<String> lambdaExp = () -> "I love Java!";
        System.out.println(lambdaExp.get());

    }
}
