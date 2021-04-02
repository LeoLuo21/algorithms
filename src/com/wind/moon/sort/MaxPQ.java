package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdRandom;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ() {
        pq = (Key[]) new Comparable[11];
    }

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N == pq.length) resize(2 * pq.length);
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (isEmpty()) return null;
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
        return max;
    }

    private void swim(int n) {
        while (n > 1 && less(n / 2, n)) {
            exch(n / 2, n);
            n = n / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void resize(int max) {
        Key[] keys = (Key[]) new Comparable[max];
        for (int i = 1; i <=N; i++) {
            keys[i] = pq[i];
        }
        pq = keys;
    }

    public static void main(String[] args) {
        MaxPQ<Double> maxPQ = new MaxPQ<>(10);
        for (int i = 0; i < 10; i++) {
            maxPQ.insert(StdRandom.uniform());
        }

        for (int i = maxPQ.size(); i > 0; i--) {
            System.out.println(maxPQ.delMax());
        }
    }
}
