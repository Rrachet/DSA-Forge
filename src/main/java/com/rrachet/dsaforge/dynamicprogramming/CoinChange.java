package com.rrachet.dsaforge.dynamicprogramming;

import java.util.Arrays;

/** Minimum coins for a target amount. Time O(amount * coins), space O(amount). */
public final class CoinChange {
    private CoinChange() {}
    public static int minCoins(int[] coins, int amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be non-negative");
        int[] dp = new int[amount + 1]; Arrays.fill(dp, amount + 1); dp[0] = 0;
        for (int current = 1; current <= amount; current++) for (int coin : coins) if (coin > 0 && coin <= current) dp[current] = Math.min(dp[current], dp[current - coin] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
