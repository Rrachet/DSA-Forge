package com.rrachet.dsaforge.trees;

import java.util.*;

/** Level-order tree traversal using BFS. Time O(n), space O(w). */
public final class LevelOrderTraversal {
    private LevelOrderTraversal() {}
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<>(); queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove(); level.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
