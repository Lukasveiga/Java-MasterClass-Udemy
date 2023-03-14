package com.masterclass.newcontent.section09.challenges;

import java.util.Scanner;

public class MinimumElement {

    public static void main(String[] args) {

        int[] array = readIntegers();
        System.out.println("Minimum value of the array: " + findMin(array));

    }

    private static int[] readIntegers() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose five integer numbers: ");

        int[] array = new int[5];

        for (int i = 0; i < 5; i++) {
            array[i] = scan.nextInt();
            scan.nextLine();
        }

        return array;
    }

    private static int findMin(int[] array){

        int min = Integer.MAX_VALUE;

        for (int n : array){
            if (n < min) {
                min = n;
            }
        }

        return min;
    }
}
