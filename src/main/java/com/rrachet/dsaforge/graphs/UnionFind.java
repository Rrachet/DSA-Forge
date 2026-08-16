package com.rrachet.dsaforge.graphs;

/** Disjoint Set Union with path compression and union by rank. Near O(1) amortized operations. */
public final class UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind(int size) {
        if (size < 0) throw new IllegalArgumentException("size cannot be negative");
        parent = new int[size]; rank = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    public int find(int value) {
        check(value);
        if (parent[value] != value) parent[value] = find(parent[value]);
        return parent[value];
    }

    public boolean union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA == rootB) return false;
        if (rank[rootA] < rank[rootB]) { int temp = rootA; rootA = rootB; rootB = temp; }
        parent[rootB] = rootA;
        if (rank[rootA] == rank[rootB]) rank[rootA]++;
        return true;
    }

    private void check(int value) {
        if (value < 0 || value >= parent.length) throw new IndexOutOfBoundsException(value);
    }
}
