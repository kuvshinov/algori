package com.kuvshinov.common.algorithms.arrays;

import java.util.Random;

/**
 * Simple sorting. My favorite in school time :)
 * O(n^2)
 */
public class SelectionSort implements Sorting {

    /**
     * Classic approach.
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minI] > arr[j]) minI = j;
            }
            int temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Also you can swap without finding min element.
     *
     * @param arr
     */
    public void sort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Selection sort for array:");
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(20);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Sorting sorting = new SelectionSort();
        sorting.sort(arr);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
