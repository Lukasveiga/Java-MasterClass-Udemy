package com.masterclass.oldcontent.section17.challenge2;

import java.util.Arrays;
import java.util.List;

public class ChallengeOne {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob");

        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase().concat(name.substring(1)))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        long count = topNames2015.stream().filter(name -> name.startsWith("A")).count();
        System.out.println("Number of names that beginning with A is: " + count);

    }
}
