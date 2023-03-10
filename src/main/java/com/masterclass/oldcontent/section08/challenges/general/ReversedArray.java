package com.masterclass.oldcontent.section08.challenges.general;

import java.util.Arrays;

public class ReversedArray {

    public static void main(String[] args) {

        int[] myArray = new int[] {1, 2, 3, 4, 5, 6,7};
        System.out.println("Array: " + Arrays.toString(myArray));
        reversedArray(myArray);
        System.out.println("Array reversed: " + Arrays.toString(myArray));    
    }

    private static void reversedArray(int[] array) {
        int last = array.length -1;
        int middle = array.length / 2;

        for (int i = 0; i < middle; i++) {
            int temp = array[i];
            array[i] = array[last - i];
            array[last - i] = temp;
        }
    }



    
}
