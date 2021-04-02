package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class AssistSort {

    public static void show(Comparable[] a) {
        StdDraw.setPenColor(Color.BLUE);
        int N =a.length;
        for (int i = 0; i<N; i++) {
            double halfWeight = 0.5/N;
            double halfHeight = (double)a[i]/2.0;
            double x = 1.0*i/N+0.5/N;
            double y = halfHeight;
            StdDraw.filledRectangle(x,y,halfWeight,halfHeight);
        }
        StdDraw.pause(1000);
        StdDraw.clear();
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i<a.length; i++) {
            if (AssistSort.less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StdDraw.setPenColor(Color.red);
        Double[] a = new Double[1000];
        for (int t = 0; t < 100; t++) {
            for (int i = 0; i < 1000; i++) {
                a[i] = StdRandom.uniform();
            }
        }
    }
}
