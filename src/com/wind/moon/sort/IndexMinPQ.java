package com.wind.moon.sort;

import edu.princeton.cs.algs4.StdRandom;

public class IndexMinPQ<Item extends Comparable<Item>> {


    private Item[] keys;
    private int[] pq;
    private int[] qp;
    private int N = 0;

    public IndexMinPQ(int maxN) {
        keys = (Item[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }


    public void insert(int k, Item item) {
        N++;
        pq[N] = k;
        qp[k] = N;
        keys[k] = item;
        swim(N);
    }

    public void change(int k, Item item) {
        keys[k] = item;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void delete(int k) {
        qp[k] = -1;
        pq[qp[k]] = 0;
        keys[k] = null;
    }

    public Item min() {
        return keys[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        keys[pq[N + 1]] = null;
        qp[pq[N + 1]] = -1;
        return indexOfMin;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
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
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]])<0;
    }

    private void resize(int max) {
        Item[] items = (Item[]) new Comparable[max];
        int[] pq1 = new int[max];
        int[] qp1 = new int[max];
        for (int i = 1; i <= N; i++) {
            items[i] = keys[i];
            pq1[i] = pq[i];
            qp1[i] = qp[i];
        }
        keys = items;
        pq = pq1;
        qp = qp1;
    }

    public static void main(String[] args) {
        IndexMinPQ<Double> minPQ = new IndexMinPQ<>(10);
        for (int i = 0; i < 10; i++) {
            minPQ.insert(StdRandom.uniform(10), StdRandom.uniform());
        }

        for (int i = minPQ.size(); i > 0; i--) {
            System.out.println(minPQ.delMin());
        }
    }
}
