package com.rrachet.dsaforge.arrays;

/** Two-pointer maximum container area. Time O(n), space O(1). */
public final class ContainerWithMostWater {
    private ContainerWithMostWater() {}
    public static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, best = 0;
        while (left < right) {
            best = Math.max(best, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] <= heights[right]) left++; else right--;
        }
        return best;
    }
}
