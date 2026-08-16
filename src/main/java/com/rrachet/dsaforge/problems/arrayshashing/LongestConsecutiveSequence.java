package com.rrachet.dsaforge.problems.arrayshashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: find the longest run of consecutive integers.
 * Pattern: hash set starts. Average time O(n), space O(n).
 */
public final class LongestConsecutiveSequence {
    private LongestConsecutiveSequence() {}

    public static int solve(int[] values) {
        Set<Integer> set = new HashSet<>();
        for (int value : values) set.add(value);
        int best = 0;
        for (int value : set) {
            if (set.contains(value - 1)) continue;
            int length = 1;
            while (set.contains(value + length)) length++;
            best = Math.max(best, length);
        }
        return best;
    }
}
