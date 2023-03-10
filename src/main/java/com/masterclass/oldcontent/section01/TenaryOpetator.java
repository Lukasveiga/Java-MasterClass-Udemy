package com.masterclass.oldcontent.section01;

public class TenaryOpetator {

    public static void main(String[] args) {

        int x = 5;
        int y = 10;

        boolean comparison = x > y ? true : false;

        if (comparison) {

            System.out.println("X is greater than y.");

        } else {

            System.out.println("Y is greater than x.");
        }

        boolean evenNumber = isEvenNumber(5);

        if (evenNumber) {

            System.out.println("The number is even.");

        } else {

            System.out.println("The number isn't even.");
        }
        
    }

    static boolean isEvenNumber(int value) {

        return value % 2 == 0;
    }
    
}
