package com.masterclass.newcontent.section09;

public class VarargsTest {

    public static void main(String[] args) {

        int num = 1;

        String text = "Hello world";

        printNumberAndTexts(num, "Hello", "Dark", "My", "Old", "Friend");

    }

    private static void printNumberAndTexts(int num1, String...texts){
        System.out.println(num1);

        for (String t : texts){
            System.out.println(t);
        }
    }
}
