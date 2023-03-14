package com.masterclass.newcontent.section09.challenges;

import java.util.Arrays;

public class ReversedArray {

    public static void main(String[] args) {

        int[] test = {1,2,3,4,5};

        System.out.println(Arrays.toString(test));

        reversed(test);

        System.out.println(Arrays.toString(test));

    }

    private static void reversed(int[] array){

        int start = 0;
        int end = array.length -1;

        int temp;

        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
