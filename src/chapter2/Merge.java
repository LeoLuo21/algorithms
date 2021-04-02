package chapter2;

public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            if (j > hi) a[k] = aux[i++];
            if (Selection.less(aux[i], aux[j])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
