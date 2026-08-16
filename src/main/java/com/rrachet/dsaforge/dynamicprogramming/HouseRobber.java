package com.rrachet.dsaforge.dynamicprogramming;

/** Maximum non-adjacent sum. Time O(n), space O(1). */
public final class HouseRobber {
    private HouseRobber() {}
    public static int max(int[] money) {
        int previousTwo = 0, previous = 0;
        for (int value : money) { int current = Math.max(previous, previousTwo + value); previousTwo = previous; previous = current; }
        return previous;
    }
}
