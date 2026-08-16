package com.rrachet.dsaforge.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/** Repeatedly extracts the two largest values using a max-heap. O(n log n). */
public final class LastStoneWeight {
    private LastStoneWeight() {}
    public static int remaining(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) heap.add(stone);
        while (heap.size() > 1) { int a = heap.poll(), b = heap.poll(); if (a != b) heap.add(a - b); }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
