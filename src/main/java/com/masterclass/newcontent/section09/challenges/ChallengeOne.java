package com.masterclass.newcontent.section09.challenges;

import java.util.Arrays;
import java.util.Random;

public class ChallengeOne {

    public static void main(String[] args) {

        /*Descending order*/

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++){

            Random rand = new Random();
            int randomNumber = rand.nextInt(100);

            array[i] = randomNumber;
        }

        System.out.println(Arrays.toString(array));

        quickSortDescending(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    private static void quickSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionDescending(arr, low, high);
            quickSortDescending(arr, low, pivotIndex - 1);
            quickSortDescending(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionDescending(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    /*Generate by ChatGPT*/
}
