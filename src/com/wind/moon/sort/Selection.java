package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (AssistSort.less(a[j], a[min])) min = j;
            AssistSort.exch(a, min, i);
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
