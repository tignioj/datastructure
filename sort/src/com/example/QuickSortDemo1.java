package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

import static com.example.ArrayUtils.printArr;
import static com.example.ArrayUtils.stringsToInts;

public class QuickSortDemo1 {

    public static void quickSort(int[] arr, int L, int R) {
        // 递归退出条件
        if (L >= R) return;

        int left = L, right = R;
        int pivot = arr[left]; // 1. 先选定基准数为l指向的数字

        while (left < right) {
            // 2. 一定要先让R从右边往左边扫描
            // 直到发现右边指向的数字小于等于基数时停止
            // left < right目的是希望在它们相遇时候停止移动
            while (left < right && arr[right] >= pivot) {
                right --;
            }

            // 3. 通过2找到了比基数小的数字的下标，把该下标指向的数放到左侧
            if (left < right) {
                arr[left] = arr[right];
            }

            // 4. 接着让L从左边往右边扫描
            // 直到发现左边指向的数字大于等于基数
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 5. 通过4找到了比基数大的数字下标，把该下标指向的数移动到右侧
            if (left < right) {
                arr[right] = arr[left];
            }

            // 6. 只有当left和right相遇后才将基数移动到left的位置
            // 为什么是left的位置？其实无所谓，left和right都一样，它们相遇了
            if (left >= right) {
                arr[left] = pivot;
            }
        }

        QuickSortDemo1.quickSort(arr,L, right-1); //处理左半段
        QuickSortDemo1.quickSort(arr,right+1, R); //处理右半段
    }


    public static void quickSort1(int[] arr, int L, int R) {
        // 递归退出条件, 也就是不能再分割的时候
        if (L >= R) return;

        int left = L, right = R;

        // 选定基数
        int pivot = arr[left];


        // 这个条件循环保证了基数左边的数都比基数小，右边的数都比基数大
        while (left < right) {
            // 1. 先移动右边, 直到找到一个比基数小的，停止移动
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            // 2. 把1找到的比基数小的数数放到左边, 不用担心arr[left]丢失，因为它再循环前已经赋值到pivot作为基数
            if (left < right) {
                arr[left] = arr[right];
            }

            // 3. 接着移动左边的下标，直到找到一个比基数大的数，停止移动
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 4. 把3找到的比基数大的数放在基数右边
            if (left < right) {
                arr[right] = arr[left];
            }

            // 5. 判断两个下标是否相遇了, 如果相遇则把基数放到相遇的地方
            if (right >= left) {
                arr[left] = pivot;
            }
        }

        // 结束一轮交换后，基数两边分别排序
        QuickSortDemo1.quickSort1(arr, L, right-1);
        QuickSortDemo1.quickSort1(arr, right+1, R);
    }

    public static void main(String[] args) {
//        int[] arr = QuickSortDemo1.generateRandomArray(10);
        int[] arr = stringsToInts("67,19,75,70,31,68,90,91,19,36");
        printArr(arr);
        System.out.println();
        quickSort1(arr, 0, arr.length-1);
        printArr(arr);
    }
}
