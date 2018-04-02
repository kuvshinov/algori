package com.kuvshinov.common.algorithms.arrays;

public class QuickSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = a[(l + r) / 2];
        int i = l, j = r;
        while (i <= j) {
            while (a[i] < p) i++;
            while (a[j] > p) j--;
            if (i <= j) {
                int temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        sort(a, l, i - 1);
        sort(a, i, r);
    }

    public static void main(String[] args) {
        System.out.println("Quick sort for:");
        int[] arr = Utils.createArray(10);
        Utils.printArray(arr);
        Sorting sorting = new QuickSort();
        sorting.sort(arr);
        Utils.printArray(arr);
    }
}
