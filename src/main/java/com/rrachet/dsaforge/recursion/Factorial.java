package com.rrachet.dsaforge.recursion;

/** Recursive factorial. Time O(n), call-stack space O(n). */
public final class Factorial {
    private Factorial() {}

    public static long of(int n) {
        if (n < 0 || n > 20) throw new IllegalArgumentException("n must be between 0 and 20");
        if (n <= 1) return 1;
        return n * of(n - 1);
    }
}
