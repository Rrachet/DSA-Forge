package com.rrachet.dsaforge.problems.arrayshashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: determine whether an integer array contains a duplicate.
 * Pattern: hashing. Time O(n) average, space O(n).
 */
public final class ContainsDuplicate {
    private ContainsDuplicate() {}

    public static boolean solve(int[] values) {
        Set<Integer> seen = new HashSet<>();
        for (int value : values) if (!seen.add(value)) return true;
        return false;
    }
}
