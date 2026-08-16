package com.rrachet.dsaforge.problems.arraystwoPointers;

import java.util.*;

/**
 * Problem: return unique triplets that sum to zero.
 * Pattern: sort + two pointers. Time O(n²), space O(n) including output.
 */
public final class ThreeSum {
    private ThreeSum() {}

    public static List<List<Integer>> solve(int[] values) {
        int[] nums = values.clone();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                } else if (sum < 0) left++; else right--;
            }
        }
        return result;
    }
}
