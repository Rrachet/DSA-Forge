package com.rrachet.dsaforge.graphs;

import java.util.*;

/** BFS and DFS traversal for an adjacency-list graph. Both are O(V + E). */
public final class GraphTraversal {
    private GraphTraversal() {}

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start); visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            order.add(node);
            for (int next : graph.getOrDefault(node, List.of())) {
                if (visited.add(next)) queue.add(next);
            }
        }
        return order;
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, visited, order);
        return order;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, List<Integer> order) {
        if (!visited.add(node)) return;
        order.add(node);
        for (int next : graph.getOrDefault(node, List.of())) dfs(graph, next, visited, order);
    }
}
