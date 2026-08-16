package com.rrachet.dsaforge.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: longest substring without repeated characters.
 * Pattern: sliding window + last-seen map. Time O(n), space O(k).
 */
public final class LongestSubstringWithoutRepeating {
    private LongestSubstringWithoutRepeating() {}

    public static int solve(String input) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < input.length(); right++) {
            char c = input.charAt(right);
            Integer previous = lastSeen.put(c, right);
            if (previous != null) left = Math.max(left, previous + 1);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
