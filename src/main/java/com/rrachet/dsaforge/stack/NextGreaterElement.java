package com.rrachet.dsaforge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/** Next greater element using a decreasing monotonic stack. Time O(n), space O(n). */
public final class NextGreaterElement {
    private NextGreaterElement() {}

    public static int[] find(int[] values) {
        int[] result = new int[values.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < values.length; i++) {
            while (!stack.isEmpty() && values[stack.peek()] < values[i]) result[stack.pop()] = values[i];
            stack.push(i);
        }
        return result;
    }
}
