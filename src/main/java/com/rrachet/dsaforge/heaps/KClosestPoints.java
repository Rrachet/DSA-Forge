package com.rrachet.dsaforge.heaps;

import java.util.PriorityQueue;

/** Keeps k closest points in a bounded max-heap. Time O(n log k), space O(k). */
public final class KClosestPoints {
    private KClosestPoints() {}
    public static int[][] find(int[][] points, int k) {
        if (k < 0 || k > points.length) throw new IllegalArgumentException("invalid k");
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(dist(b), dist(a)));
        for (int[] point : points) { heap.offer(point); if (heap.size() > k) heap.poll(); }
        int[][] result = new int[k][]; for (int i = 0; i < k; i++) result[i] = heap.poll(); return result;
    }
    private static int dist(int[] p) { return p[0] * p[0] + p[1] * p[1]; }
}
