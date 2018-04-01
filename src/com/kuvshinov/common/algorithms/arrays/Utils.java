package com.kuvshinov.common.algorithms.arrays;

import java.util.Random;

public class Utils {

    private Utils() {}

    public static int[] createArray(int size) {
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(20) - 10;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
