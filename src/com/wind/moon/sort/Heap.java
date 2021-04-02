package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a,k,N);
        }

        while (N>1) {
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private static void exch(Comparable[] a, int p, int c) {
        Comparable temp = a[p-1];
        a[p-1] = a[c-1];
        a[c-1] = temp;
    }

    private static boolean less(Comparable[] a, int p, int c) {
        return a[p-1].compareTo(a[c-1])<0;
    }

    private static void sink(Comparable[] a, int p, int c) {
        while (2*p<=c) {
            int j = 2*p;
            if (j<c&&less(a,j,j+1)){
                j++;
            }
            if (!less(a,p,j)) break;
            exch(a,p,j);
            p = j;
        }
    }

    public static void main(String[] args) {
        Double[] test = new Double[10];
        for (int i = 0; i<test.length; i++) {
            test[i] = StdRandom.uniform();
        }
        sort(test);
        System.out.println(AssistSort.isSorted(test));
    }
}
