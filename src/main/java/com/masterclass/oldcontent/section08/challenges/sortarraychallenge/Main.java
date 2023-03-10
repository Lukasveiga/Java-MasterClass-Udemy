package com.masterclass.oldcontent.section08.challenges.sortarraychallenge;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        SortArrays sortArrays = new SortArrays();

        int[] arrayIntegers = sortArrays.getIntegers(scan);
        sortArrays.printArray(arrayIntegers);

        sortArrays.printArray(sortArrays.sortIntegers(arrayIntegers));
        sortArrays.printArray(sortArrays.decresingArrayOrder(arrayIntegers));

        
        
    }
    
}
