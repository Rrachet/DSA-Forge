package com.rrachet.dsaforge.arrays;

/** Maximum single-transaction stock profit. Time O(n), space O(1). */
public final class BestTimeToBuySellStock {
    private BestTimeToBuySellStock() {}
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) { min = Math.min(min, price); profit = Math.max(profit, price - min); }
        return profit;
    }
}
