package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && AssistSort.less(a[j], a[j - 1]); j--)
                AssistSort.exch(a, j, j - 1);
            AssistSort.show(a);
        }
    }

    public static void main(String[] args) {
        Double[] a = new Double[30];
            for (int i = 0; i < 30; i++) {
                a[i] = StdRandom.uniform();
            }
        sort(a);
    }
}

