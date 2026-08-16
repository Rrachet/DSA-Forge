package com.rrachet.dsaforge.backtracking;

import java.util.ArrayList;
import java.util.List;

/** Generates all subsets using backtracking. Time O(n * 2^n), output space O(n * 2^n). */
public final class Subsets {
    private Subsets() {}

    public static List<List<Integer>> generate(int[] values) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(values, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] values, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < values.length; i++) {
            current.add(values[i]);
            backtrack(values, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
