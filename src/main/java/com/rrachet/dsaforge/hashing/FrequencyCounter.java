package com.rrachet.dsaforge.hashing;

import java.util.HashMap;
import java.util.Map;

/** Builds a frequency map in expected O(n) time and O(k) space. */
public final class FrequencyCounter {
    private FrequencyCounter() {}

    public static Map<Integer, Integer> count(int[] values) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int value : values) frequencies.merge(value, 1, Integer::sum);
        return frequencies;
    }
}
