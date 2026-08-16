package com.rrachet.dsaforge.sorting;

/** Stable divide-and-conquer sorting. Time O(n log n), space O(n). */
public final class MergeSort {
    private MergeSort() {}

    public static void sort(int[] values) {
        if (values.length < 2) return;
        int[] buffer = new int[values.length];
        sort(values, buffer, 0, values.length - 1);
    }

    private static void sort(int[] a, int[] b, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(a, b, left, mid);
        sort(a, b, mid + 1, right);
        merge(a, b, left, mid, right);
    }

    private static void merge(int[] a, int[] b, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) b[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= mid) b[k++] = a[i++];
        while (j <= right) b[k++] = a[j++];
        for (i = left; i <= right; i++) a[i] = b[i];
    }
}
