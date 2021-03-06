package chapter1.practice;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Draw {
    public static void main(String[] args) {
        StdDraw.setPenColor(Color.BLUE);
       int N = 50;
       double[] a = new double[N];
       for (int i = 0; i<N; i++ ) {
           //a[i] = StdRandom.random();
           a[i] = StdRandom.uniform();
       }
       for (int i = 0; i<N; i++) {
           double x = 1.0*i/N+0.5/N;
           double y = a[i]/2.0;
           double rw = 0.5/N;
           double rh = a[i]/2.0;
           StdDraw.filledRectangle(x,y,rw,rh);
       }
    }
}
