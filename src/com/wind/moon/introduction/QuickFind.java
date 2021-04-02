package com.wind.moon.introduction;

public class QuickFind {
    private int N;
    private int[] id;
    private int count;

    public QuickFind(int n) {
        N = n;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public int find(int p) {
        return id[p];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < N; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
