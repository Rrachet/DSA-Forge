package com.rrachet.dsaforge.graphs;

import java.util.*;

/** Clones an undirected graph with DFS and a visited map. Time O(V+E), space O(V). */
public final class CloneGraph {
    public static final class Node { public int value; public List<Node> neighbors = new ArrayList<>(); public Node(int value) { this.value = value; } }
    private CloneGraph() {}
    public static Node clone(Node source) { return clone(source, new HashMap<>()); }
    private static Node clone(Node node, Map<Node,Node> seen) {
        if (node == null) return null; if (seen.containsKey(node)) return seen.get(node);
        Node copy = new Node(node.value); seen.put(node, copy);
        for (Node neighbor : node.neighbors) copy.neighbors.add(clone(neighbor, seen));
        return copy;
    }
}
