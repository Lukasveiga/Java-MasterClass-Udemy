package com.masterclass.oldcontent.section08.challenges.general;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumArray {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] myArray = readIntegers(scanner);
        System.out.println("Array: " + Arrays.toString(myArray));
        System.out.println("Min value of array is: " + findMinimum(myArray));

    }

    private static int[] readIntegers(Scanner scan) {

        System.out.println("Informe the lenght of array: ");
        int arrayLength = scan.nextInt();

        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Value #" + (i + 1) + ": ");
            array[i] = scan.nextInt();
        }

        return array;

    }

    private static int findMinimum(int[] array) {
        int minimum = Integer.MAX_VALUE;

        for (int value: array) {

            if (value < minimum) {

                minimum = value;
            }
        }

        return minimum;
    }
    
}
