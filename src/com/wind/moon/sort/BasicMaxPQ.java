package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdRandom;

public class BasicMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public BasicMaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public void insert(Key v) {
        if (N == pq.length) resize(2 * pq.length);
        pq[++N] = v;
    }

    private void resize(int max) {
        Key[] keys = (Key[]) new Comparable[max];
        for (int i = 1; i <=N; i++) {
            keys[i] = pq[i];
        }
        pq = keys;
    }

    public Key max() {
        if (isEmpty()) return null;
        for (int i = 1; i <= N; i++) {
            if (pq[i].compareTo(pq[N]) > 0) {
                Key temp = pq[i];
                pq[i] = pq[N];
                pq[N] = temp;
            }
        }
        return pq[N];
    }

    public Key delMax() {
        if (isEmpty()) return null;
        Key max = max();
        pq[N--] = null;
        if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public static void main(String[] args) {
        BasicMaxPQ<Double> basicMaxPQ = new BasicMaxPQ<Double>(10);
        for (int i =0;i<10;i++) {
            basicMaxPQ.insert(StdRandom.uniform());
        }
        for (int i = basicMaxPQ.size(); i>0; i--) {
            System.out.println(basicMaxPQ.delMax());
        }
        System.out.println(basicMaxPQ.size());
    }
}
