package com.masterclass.newcontent.section09;

import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args) {

        /*
        * The array has to be sorted;
        * If there are duplicates values there's no guarantee which one it'll march on;
        * Elements must be comparable.
        */

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);

        System.out.println(Arrays.toString(sArray));

        searchInArray(sArray, "Ralph");

    }

    private static void searchInArray(String[] array, String name){

        int index = Arrays.binarySearch(array, name);

        if (index >= 0){
            System.out.printf("%s was found at position %d in the list.", name, index);
        } else {
            System.out.printf("%s wasn't found in the list.", name);
        }
    }
}
