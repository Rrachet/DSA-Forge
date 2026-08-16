package com.rrachet.dsaforge.dynamicprogramming;

/** Fibonacci-style dynamic programming. Time O(n), space O(1). */
public final class ClimbingStairs {
    private ClimbingStairs() {}
    public static int ways(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return 1;
        int previous = 1, current = 1;
        for (int step = 2; step <= n; step++) { int next = previous + current; previous = current; current = next; }
        return current;
    }
}
