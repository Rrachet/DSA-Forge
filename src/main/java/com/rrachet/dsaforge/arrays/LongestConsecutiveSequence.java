package com.rrachet.dsaforge.arrays;

import java.util.HashSet;
import java.util.Set;

/** Hash-set longest consecutive run. Expected O(n) time, O(n) space. */
public final class LongestConsecutiveSequence {
    private LongestConsecutiveSequence() {}
    public static int length(int[] values) {
        Set<Integer> set = new HashSet<>(); for (int value : values) set.add(value);
        int best = 0;
        for (int value : set) if (!set.contains(value - 1)) {
            int current = value;
            while (set.contains(current + 1)) current++;
            best = Math.max(best, current - value + 1);
        }
        return best;
    }
}
