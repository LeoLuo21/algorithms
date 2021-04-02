package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && AssistSort.less(a[j], a[j - h]); j -= h)
                    AssistSort.exch(a, j, j - h);
                AssistSort.show(a);
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Double[] a = new Double[30];
        for (int t = 0; t < 100; t++) {
            for (int i = 0; i < 30; i++) {
                a[i] = StdRandom.uniform();
            }
        }
        sort(a);
    }
}
