package com.rrachet.dsaforge.dynamicprogramming;

/** 0/1 knapsack using one-dimensional DP. Time O(n * capacity), space O(capacity). */
public final class Knapsack01 {
    private Knapsack01() {}

    public static int maxValue(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || capacity < 0) throw new IllegalArgumentException("invalid input");
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= 0) throw new IllegalArgumentException("weights must be positive");
            for (int c = capacity; c >= weights[i]; c--) {
                dp[c] = Math.max(dp[c], dp[c - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }
}
