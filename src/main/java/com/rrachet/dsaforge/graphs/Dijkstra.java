package com.rrachet.dsaforge.graphs;

import java.util.*;

/** Dijkstra shortest paths for graphs with non-negative edge weights. O((V+E) log V). */
public final class Dijkstra {
    private Dijkstra() {}

    public record Edge(int to, int weight) {}

    public static Map<Integer, Long> shortestPaths(Map<Integer, List<Edge>> graph, int source) {
        Map<Integer, Long> distance = new HashMap<>();
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        distance.put(source, 0L);
        queue.offer(new long[]{source, 0});
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            int node = (int) current[0];
            long best = current[1];
            if (best != distance.getOrDefault(node, Long.MAX_VALUE)) continue;
            for (Edge edge : graph.getOrDefault(node, List.of())) {
                if (edge.weight() < 0) throw new IllegalArgumentException("negative edge weight");
                long candidate = best + edge.weight();
                if (candidate < distance.getOrDefault(edge.to(), Long.MAX_VALUE)) {
                    distance.put(edge.to(), candidate);
                    queue.offer(new long[]{edge.to(), candidate});
                }
            }
        }
        return distance;
    }
}
