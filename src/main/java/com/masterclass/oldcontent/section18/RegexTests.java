package com.masterclass.oldcontent.section18;

import java.util.regex.Pattern;

public class RegexTests {

    public static void main(String[] args) {

        String test1 = "Ontem faltou água, Anteontem faltou luz";
        boolean resultMatch = Pattern.matches("(?i)ontem", test1);
        System.out.println(resultMatch);

    }

}
