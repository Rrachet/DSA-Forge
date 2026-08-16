package com.rrachet.dsaforge.problems.arraystwoPointers;

/**
 * Problem: find two indices in a sorted array whose values sum to target.
 * Pattern: two pointers. Time O(n), space O(1).
 */
public final class TwoSumSorted {
    private TwoSumSorted() {}

    public static int[] solve(int[] values, int target) {
        int left = 0, right = values.length - 1;
        while (left < right) {
            long sum = (long) values[left] + values[right];
            if (sum == target) return new int[]{left, right};
            if (sum < target) left++; else right--;
        }
        return new int[0];
    }
}
