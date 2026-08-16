package com.rrachet.dsaforge.trees;

/** Maximum binary-tree depth. Time O(n), space O(h). */
public final class MaximumDepth {
    private MaximumDepth() {}
    public static int of(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(of(root.left), of(root.right));
    }
}
