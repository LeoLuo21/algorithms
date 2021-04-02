package chapter2;

public class Selection {
    private Selection(){}
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++) {
                if (less(a[min], a[j]))
                    min = j;
                exch(a, i, min);
            }
        }
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j)<0;
    }

    public static void exch(Comparable[] a, int i, int min) {
        Comparable temp = a[min];
        a[min] = a[i];
        a[i] = temp;
    }
}
