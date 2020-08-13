package com.example;

import java.util.Random;

public class ArrayUtils {
    public int[] sort = {10, 32, 13, 15, 6, 2, 99, 1};
    public static int[] generateRandomArray (int len) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }


    public static int[] stringsToInts(String string) {
        String[] split = string.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
