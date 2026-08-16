package com.rrachet.dsaforge.problems.arrayshashing;

/**
 * Problem: product of every array element except self, without division.
 * Pattern: prefix/suffix products. Time O(n), extra space O(1) excluding output.
 */
public final class ProductExceptSelf {
    private ProductExceptSelf() {}

    public static int[] solve(int[] values) {
        int[] result = new int[values.length];
        int prefix = 1;
        for (int i = 0; i < values.length; i++) {
            result[i] = prefix;
            prefix *= values[i];
        }
        int suffix = 1;
        for (int i = values.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= values[i];
        }
        return result;
    }
}
