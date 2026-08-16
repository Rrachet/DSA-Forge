package com.rrachet.dsaforge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/** Stack supporting minimum lookup in O(1) time. */
public final class MinStack {
    private final Deque<Integer> values = new ArrayDeque<>();
    private final Deque<Integer> minimums = new ArrayDeque<>();
    public void push(int value) { values.push(value); minimums.push(minimums.isEmpty() ? value : Math.min(value, minimums.peek())); }
    public int pop() { if (values.isEmpty()) throw new IllegalStateException("stack is empty"); minimums.pop(); return values.pop(); }
    public int top() { if (values.isEmpty()) throw new IllegalStateException("stack is empty"); return values.peek(); }
    public int min() { if (minimums.isEmpty()) throw new IllegalStateException("stack is empty"); return minimums.peek(); }
}
