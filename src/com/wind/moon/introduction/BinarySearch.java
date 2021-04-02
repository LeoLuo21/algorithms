package com.wind.moon.introduction;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2;
            if (key < a[mid])
                end = mid;
            else if (key > a[mid])
                start = mid;
            else
                return mid;
        }
        return -1;
    }
}
