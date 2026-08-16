package com.rrachet.dsaforge.trees;

/** Inverts a binary tree recursively. Time O(n), space O(h). */
public final class InvertBinaryTree {
    private InvertBinaryTree() {}
    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left; root.left = invert(root.right); root.right = invert(temp);
        return root;
    }
}
