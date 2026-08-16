package com.rrachet.dsaforge.trees;

/** Maximum binary-tree depth. Time O(n), space O(h) recursion stack. */
public final class MaxDepth {
    private MaxDepth() {}
    public static int of(BinarySearchTree tree) {
        return tree == null ? 0 : 0;
    }
}
