package chapter1.practice;

import java.util.Random;

public class S {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] testNumbers = new Integer[10];
        for (int i = 0; i < testNumbers.length; i++) {
            testNumbers[i] = random.nextInt(10);
        }
        //bubbleSort(testNumbers);
        //selectSort(testNumbers);
        insertSort(testNumbers);
        for (int i = 0; i < testNumbers.length; i++) {
            System.out.println(testNumbers[i]);
        }
    }

    /*
     * 冒泡排序
     * */

    public static void bubbleSort(Comparable[] a) {
        int N = a.length;
        for (int i = N - 1; i >= 0; i--)
            for (int j = 0; j < i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Comparable temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
    }

    /*
     * 选择排序
     * */
    public static void selectSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            Comparable temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    /*
     * 插入排序
     * */

    public static void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
                Comparable temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
}
