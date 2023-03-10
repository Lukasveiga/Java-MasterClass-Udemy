package com.masterclass.oldcontent.section08.challenges.sortarraychallenge;

import java.util.Scanner;

public class SortArrays {

    private int arrayIntegers[];

    public int[] getIntegers(Scanner scan) {

        System.out.println("Digit the lenght of array: ");
        int lenght = scan.nextInt();
        arrayIntegers = new int[lenght];

        for(int i = 0; i < arrayIntegers.length; i++) {
            System.out.println("Value #" + (i+1) + ": ");
            arrayIntegers[i] = scan.nextInt();
        }

        return arrayIntegers;

    }

    public void printArray(int[] arrayIntegers) {
        for (int value : arrayIntegers) {
            System.out.print(value + " ");
        }
        System.out.println();

    }

    public int[] sortIntegers(int[] arrayIntegers) {

        int[] w = new int[arrayIntegers.length];
        mergeSort(arrayIntegers, w, 0, arrayIntegers.length - 1);
        return arrayIntegers;
    }

    public int[] decresingArrayOrder(int[] arrayIntegers) {
        int last = arrayIntegers.length -1;
        int middle = arrayIntegers.length / 2;

        for (int i = 0; i < middle; i++) {
            int temp = arrayIntegers[i];
            arrayIntegers[i] = arrayIntegers[last - i];
            arrayIntegers[last - i] = temp;
        }

        return arrayIntegers;
    }

    private void mergeSort(int[] arr, int[] w, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, w, start, middle);
            mergeSort(arr, w, middle + 1, end);
            intercalaryVectores(arr, w, start, middle, end);
        }
    }

    private void intercalaryVectores(int[] arr, int[] w, int start, int middle, int end) {
        for (int k = start; k <= end; k++) {
            w[k] = arr[k];
        }

        int i = start;
        int j = middle + 1;

        for (int k = start; k <= end; k++){
            if (i > middle) {
                arr[k] = w[j++];
            }
            else if (j > end) {
                arr[k] = w[i++];
            }
            else if (w[i] < w[j]) {
                arr[k] = w[i++];
            }
            else {
                arr[k] = w[j++];
            }
        }
    }
    
}
