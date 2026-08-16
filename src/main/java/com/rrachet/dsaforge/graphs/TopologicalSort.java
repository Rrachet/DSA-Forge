package com.rrachet.dsaforge.graphs;

import java.util.*;

/** Kahn's algorithm for topological ordering of a DAG. Time O(V+E), space O(V). */
public final class TopologicalSort {
    private TopologicalSort() {}

    public static List<Integer> sort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();
        graph.keySet().forEach(node -> indegree.putIfAbsent(node, 0));
        for (List<Integer> edges : graph.values()) for (int to : edges) indegree.merge(to, 1, Integer::sum);
        Deque<Integer> queue = new ArrayDeque<>();
        indegree.forEach((node, degree) -> { if (degree == 0) queue.add(node); });
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            order.add(node);
            for (int next : graph.getOrDefault(node, List.of())) {
                int degree = indegree.merge(next, -1, Integer::sum);
                if (degree == 0) queue.add(next);
            }
        }
        if (order.size() != indegree.size()) throw new IllegalArgumentException("graph contains a cycle");
        return order;
    }
}
