package com.rrachet.dsaforge.searching;

/** Lower-bound binary search. Time O(log n), space O(1). */
public final class SearchInsertPosition {
    private SearchInsertPosition() {}
    public static int find(int[] values, int target) {
        int left = 0, right = values.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values[mid] < target) left = mid + 1; else right = mid;
        }
        return left;
    }
}
