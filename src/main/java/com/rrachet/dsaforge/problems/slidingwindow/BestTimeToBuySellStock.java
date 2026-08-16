package com.rrachet.dsaforge.problems.slidingwindow;

/**
 * Problem: maximize profit from one buy and one later sell.
 * Pattern: running minimum / one-pass window. Time O(n), space O(1).
 */
public final class BestTimeToBuySellStock {
    private BestTimeToBuySellStock() {}

    public static int solve(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            best = Math.max(best, price - minPrice);
        }
        return best;
    }
}
