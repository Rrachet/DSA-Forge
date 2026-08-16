package com.rrachet.dsaforge.arrays;

/** Kadane's algorithm. Time O(n), space O(1). */
public final class MaximumSubarray {
    private MaximumSubarray() {}
    public static int maxSum(int[] values) {
        if (values.length == 0) throw new IllegalArgumentException("array cannot be empty");
        int current = values[0], best = values[0];
        for (int i = 1; i < values.length; i++) { current = Math.max(values[i], current + values[i]); best = Math.max(best, current); }
        return best;
    }
}
