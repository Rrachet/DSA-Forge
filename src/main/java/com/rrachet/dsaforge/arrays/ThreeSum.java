package com.rrachet.dsaforge.arrays;

import java.util.*;

/** Three Sum using sorting and two pointers. Time O(n²), space O(n) for output/sort. */
public final class ThreeSum {
    private ThreeSum() {}
    public static List<List<Integer>> find(int[] values) {
        int[] a = values.clone(); Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int left = i + 1, right = a.length - 1;
            while (left < right) {
                long sum = (long) a[i] + a[left] + a[right];
                if (sum == 0) {
                    result.add(List.of(a[i], a[left], a[right]));
                    while (left < right && a[left] == a[left + 1]) left++;
                    while (left < right && a[right] == a[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) left++; else right--;
            }
        }
        return result;
    }
}
