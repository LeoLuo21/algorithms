package chapter1.practice;

public class WeightedQuickUinionUF{
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUinionUF(int N) {
        id = new int[N];
        for (int i = 0; i<N; i++) {
            id[i] = i;
        }
        size = new int[N];
        for (int i = 0; i<N; i++) {
            size[i] = 1;
        }
        count = N;
    }

    public int count() {
        return count;
    }

    public int find (int p) {
        while (p!=id[p]) p = id[p];
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[p] < size[q]) {
            id[p] = q;
            size[q] += size[p];
        } else {
            id[q] = p;
            size[p] += size[q];
        }
        count--;
    }

    public static void main (String[] args) {
        WeightedQuickUinionUF uf = new WeightedQuickUinionUF(10);
        uf.union(1,5);
        uf.union(1, 9);
        System.out.println(uf.isConnected(5, 9));
    }
}