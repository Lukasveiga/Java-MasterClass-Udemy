package com.masterclass.oldcontent.section18;

public class Main {

    public static void main(String[] args) {

        String string = "I am a string. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("[aeiou]", "#");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiiijkl99z";
        //System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12abcDeeeGhhiiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));
        System.out.println(secondString.replaceAll("ijkl99z$", "THE END"));
        System.out.println(secondString.replaceAll("[aei][Fj]", "X"));
        System.out.println(secondString.replaceAll("(?i)[a-f3-8]", "X"));

    }
}
