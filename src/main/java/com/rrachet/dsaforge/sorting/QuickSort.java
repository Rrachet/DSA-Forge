package com.rrachet.dsaforge.sorting;

/** In-place quicksort using Lomuto partitioning. Average O(n log n), worst O(n^2). */
public final class QuickSort {
    private QuickSort() {}

    public static void sort(int[] values) {
        quicksort(values, 0, values.length - 1);
    }

    private static void quicksort(int[] a, int low, int high) {
        if (low >= high) return;
        int pivot = partition(a, low, high);
        quicksort(a, low, pivot - 1);
        quicksort(a, pivot + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high], store = low;
        for (int i = low; i < high; i++) {
            if (a[i] <= pivot) swap(a, i, store++);
        }
        swap(a, store, high);
        return store;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
