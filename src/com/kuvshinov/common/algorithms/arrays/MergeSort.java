package com.kuvshinov.common.algorithms.arrays;

/**
 * O(n*log(n)). Quick but need more memory.
 */
public class MergeSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 1)
            return;
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] a, int l, int r) {
        if (l == r) return;
        int p = (r + l) / 2;
        sort(a, l, p);
        sort(a, p + 1, r);
        merge(a, l, r, p);
    }

    private void merge(int[] arr, int l, int r, int p) {
        int[] a = new int[p - l + 1], b = new int[r - p];
        System.arraycopy(arr, l, a, 0, a.length);
        System.arraycopy(arr, p + 1, b, 0, b.length);
        int i = 0, j = 0, k = l;
        while(i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }
        if (i < a.length) {
            System.arraycopy(a, i, arr, k, a.length - i);
        }
        if (j < b.length) {
            System.arraycopy(b, j, arr, k, b.length - j);
        }
    }

    public static void main(String[] args) {
        System.out.println("Merge sort for: ");
        int[] a = Utils.createArray(10);
        Utils.printArray(a);
        Sorting sorting = new MergeSort();
        sorting.sort(a);
        Utils.printArray(a);
    }
}
