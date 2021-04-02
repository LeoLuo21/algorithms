package chapter2;

public class Insertion {
    private Insertion() {
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Selection.less(a[j], a[j - 1]); j--)
                Selection.exch(a, j, j - 1);
        }
    }
}
