package com.rrachet.dsaforge.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/** Monotonic deque sliding-window maximum. Time O(n), space O(k). */
public final class SlidingWindowMaximum {
    private SlidingWindowMaximum() {}

    public static int[] find(int[] values, int k) {
        if (k <= 0 || k > values.length) throw new IllegalArgumentException("invalid window size");
        int[] result = new int[values.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < values.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.removeFirst();
            while (!deque.isEmpty() && values[deque.peekLast()] <= values[i]) deque.removeLast();
            deque.addLast(i);
            if (i >= k - 1) result[i - k + 1] = values[deque.peekFirst()];
        }
        return result;
    }
}
