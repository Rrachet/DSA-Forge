package com.rrachet.dsaforge.problems.arrayshashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: determine whether two strings are anagrams.
 * Pattern: frequency map. Time O(n), space O(k).
 */
public final class ValidAnagram {
    private ValidAnagram() {}

    public static boolean solve(String first, String second) {
        if (first.length() != second.length()) return false;
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : first.toCharArray()) counts.merge(c, 1, Integer::sum);
        for (char c : second.toCharArray()) {
            Integer count = counts.get(c);
            if (count == null) return false;
            if (count == 1) counts.remove(c); else counts.put(c, count - 1);
        }
        return counts.isEmpty();
    }
}
