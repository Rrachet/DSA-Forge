package com.rrachet.dsaforge.searching;

/** Binary search in a rotated sorted array with distinct values. O(log n) time, O(1) space. */
public final class SearchInRotatedSortedArray {
    private SearchInRotatedSortedArray() {}
    public static int find(int[] values, int target) {
        int left = 0, right = values.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values[mid] == target) return mid;
            if (values[left] <= values[mid]) {
                if (values[left] <= target && target < values[mid]) right = mid - 1; else left = mid + 1;
            } else {
                if (values[mid] < target && target <= values[right]) left = mid + 1; else right = mid - 1;
            }
        }
        return -1;
    }
}
