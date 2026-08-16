package com.rrachet.dsaforge.problems.arraystwoPointers;

/**
 * Problem: maximize water contained between two vertical lines.
 * Pattern: two pointers. Time O(n), space O(1).
 */
public final class ContainerWithMostWater {
    private ContainerWithMostWater() {}

    public static int solve(int[] heights) {
        int left = 0, right = heights.length - 1, best = 0;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            best = Math.max(best, area);
            if (heights[left] <= heights[right]) left++; else right--;
        }
        return best;
    }
}
