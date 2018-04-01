package com.kuvshinov.common.algorithms.arrays;

/**
 * O(n^2)
 */
public class BubbleSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Bubble sort for array:");
        int[] arr = Utils.createArray(10);
        Utils.printArray(arr);
        Sorting sorting = new BubbleSort();
        sorting.sort(arr);
        Utils.printArray(arr);
    }
}
