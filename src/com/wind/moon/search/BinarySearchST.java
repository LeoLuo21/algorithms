package com.wind.moon.search;

import edu.princeton.cs.algs4.StdRandom;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;


    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            for (int j = i; j < N - 2; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
                keys[N] = null;
                values[N] = null;
                N--;
            }
        }
    }

    public Key select(int k) {
        if (k < N) {
            return keys[k];
        }
        return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, Object> st = new BinarySearchST<>(10);
        for (int i = 0; i < 10; i++) {
            st.put(StdRandom.uniform(10), StdRandom.uniform());
        }
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.select(i));
        }
    }
}

