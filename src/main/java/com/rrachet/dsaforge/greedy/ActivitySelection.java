package com.rrachet.dsaforge.greedy;

import java.util.Arrays;

/** Maximum non-overlapping activities. Time O(n log n), space O(n) for sorting. */
public final class ActivitySelection {
    private ActivitySelection() {}

    public record Activity(int start, int finish) {}

    public static int maximum(Activity[] activities) {
        Activity[] sorted = activities.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a.finish(), b.finish()));
        int count = 0;
        int lastFinish = Integer.MIN_VALUE;
        for (Activity activity : sorted) {
            if (activity.start() >= lastFinish) {
                count++;
                lastFinish = activity.finish();
            }
        }
        return count;
    }
}
