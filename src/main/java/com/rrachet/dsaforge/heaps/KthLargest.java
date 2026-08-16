package com.rrachet.dsaforge.heaps;

import java.util.PriorityQueue;

/** Finds the kth largest value using a min-heap. Time O(n log k), space O(k). */
public final class KthLargest {
    private KthLargest() {}

    public static int find(int[] values, int k) {
        if (k <= 0 || k > values.length) throw new IllegalArgumentException("invalid k");
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : values) {
            heap.offer(value);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
