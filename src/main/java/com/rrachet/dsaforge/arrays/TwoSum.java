package com.rrachet.dsaforge.arrays;

import java.util.HashMap;
import java.util.Map;

/** Finds two indices whose values sum to target. Average time O(n), space O(n). */
public final class TwoSum {
    private TwoSum() {}

    public static int[] find(int[] values, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            int complement = target - values[i];
            if (seen.containsKey(complement)) return new int[]{seen.get(complement), i};
            seen.put(values[i], i);
        }
        return new int[0];
    }
}
