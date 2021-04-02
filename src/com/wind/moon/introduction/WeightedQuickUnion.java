package com.wind.moon.introduction;

public class WeightedQuickUnion {
    private int N;
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUnion(int n) {
        N = n;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
        count = N;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[p] < size[q]) {
            id[pRoot] = qRoot;
            size[q] += size[p];
        } else {
            id[qRoot] = pRoot;
            size[p] += size[q];
        }
        count--;
    }
}
