package com.rrachet.dsaforge.problems.arrayshashing;

import java.util.*;

/**
 * Problem: group strings that are anagrams.
 * Pattern: canonical frequency signature. Average time O(n*k), space O(n*k).
 */
public final class GroupAnagrams {
    private GroupAnagrams() {}

    public static List<List<String>> solve(String[] words) {
        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String word : words) {
            int[] frequency = new int[26];
            for (char c : word.toCharArray()) frequency[c - 'a']++;
            String key = Arrays.toString(frequency);
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}
