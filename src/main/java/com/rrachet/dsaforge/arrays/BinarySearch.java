package com.rrachet.dsaforge.arrays;

/** Binary search over a sorted integer array. Time O(log n), space O(1). */
public final class BinarySearch {
    private BinarySearch() {}

    public static int find(int[] values, int target) {
        int left = 0, right = values.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values[mid] == target) return mid;
            if (values[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
