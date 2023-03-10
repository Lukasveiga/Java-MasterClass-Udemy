package com.masterclass.oldcontent.section18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndOrNotRegex {

    public static void main(String[] args) {

        // And operator -> eg.: "abc" = "a" and "b" and "c";
        System.out.println("hello abcdude".replaceAll("abc", "dear "));

        // Or operator -> eg.: "[H|h]arry" = "Harry" or "harry";
        System.out.println("harry".replaceAll("[H|h]arry", "Thomas"));

        // Not operator -> eg.: "[^abc]" = "defgh...";
        //String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher("tvsstsgjtut");

        int count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        //+55 083 95555-5555
        //"[+][1-9]{2][ ]9[0-9]{4}[-][0-9]{4}"
        String phoneNumberBrazil = "+55 083 95555-5555";
        String phoneNumberBrazilRegEx = "^[+][1-9]{2} [0-9]{3} 9[0-9]{4}-[0-9]{4}$";

        if (phoneNumberBrazil.matches(phoneNumberBrazilRegEx)) {
            System.out.println("Valid input: " + phoneNumberBrazil);
        } else {
            System.out.println("Invalid input.");
        }


    }
}
