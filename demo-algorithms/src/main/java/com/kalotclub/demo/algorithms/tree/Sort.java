package com.kalotclub.demo.algorithms.tree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 2019-10-31 00:19
 *
 * @author hongchen.cao
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        ReentrantLock
        quickSort(a);
        for (int i = 0; i < 10; ++i) {
            System.out.println(a[i]);
        }
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length);
    }

    private static void quickSort(int[] a, int x, int y) {
        if (y - x > 1) {
            int q = partition(a, x, y);
            quickSort(a, x, q);
            quickSort(a, q, y);
        }
    }

    private static int partition(int[] a, int x, int y) {
        int pivot = a[y - 1];
        int i = x - 1, j = x;
        for (; j < y - 1; ++j) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, y - 1);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    private static void mergeSort(int[] a, int x, int y) {
        if (y - x > 1) {
            int[] tmp = new int[y - x];
            int m = x + (y - x) / 2;
            mergeSort(a, x, m);
            mergeSort(a, m, y);
            int p = x, q = m, index = 0;
            while (p < m || q < y) {
                if (q >= y || (p < m && a[p] <= a[q])) {
                    tmp[index++] = a[p++];
                } else {
                    tmp[index++] = a[q++];
                }
            }

            for (int i = x, j = 0; i < y; ++i) {
                a[i] = tmp[j++];
            }
        }
    }
}
