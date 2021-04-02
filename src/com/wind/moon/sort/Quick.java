package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.PriorityQueue;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (AssistSort.less(a[++i],v)) if (i == hi) break;
            while (AssistSort.less(v,a[--j])) if (j == lo) break;
            if (i >= j) break;
            AssistSort.exch(a,i,j);
        }
        AssistSort.exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) {
        PriorityQueue<Object> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(StdRandom.uniform(20));
        }
        for (int i = 0; i<10; i++) {
            Object poll = priorityQueue.poll();
            System.out.println(poll);
        }
    }
}