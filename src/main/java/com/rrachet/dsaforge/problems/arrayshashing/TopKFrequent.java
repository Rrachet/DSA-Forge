package com.rrachet.dsaforge.problems.arrayshashing;

import java.util.*;

/**
 * Problem: return the k most frequent integers.
 * Pattern: frequency map + min-heap. Time O(n log k), space O(n).
 */
public final class TopKFrequent {
    private TopKFrequent() {}

    public static int[] solve(int[] values, int k) {
        if (k <= 0 || k > values.length) throw new IllegalArgumentException("invalid k");
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int value : values) frequency.merge(value, 1, Integer::sum);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(frequency::get));
        for (int value : frequency.keySet()) {
            heap.offer(value);
            if (heap.size() > k) heap.poll();
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = heap.poll();
        return result;
    }
}
