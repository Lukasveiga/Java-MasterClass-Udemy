package com.masterclass.oldcontent.section19.challengeOne;

import java.security.SecureRandom;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Utilities utilities = new Utilities();

        char[] test = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        System.out.println(Arrays.toString(utilities.everyNthChar(test, 0)));

        /*String s = "abccabdeff";*/

        System.out.println(utilities.removePairs(null));

        System.out.println(utilities.nullIfOddLength("javasa"));

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 4; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);

            System.out.println(utilities.converter(a,b) + ", " + a + ", " + b);
        }

        try {
            System.out.println(utilities.converter(10,0));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }



    }
}
