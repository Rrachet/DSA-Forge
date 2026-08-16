package com.rrachet.dsaforge.strings;

/** Prefix tree for lowercase English words. Insert/search/prefix are O(L). */
public final class Trie {
    private final Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) current = current.children.computeIfAbsent(c, ignored -> new Node());
        current.word = true;
    }

    public boolean contains(String word) {
        Node node = nodeFor(word);
        return node != null && node.word;
    }

    public boolean startsWith(String prefix) { return nodeFor(prefix) != null; }

    private Node nodeFor(String value) {
        Node current = root;
        for (char c : value.toCharArray()) {
            current = current.children.get(c);
            if (current == null) return null;
        }
        return current;
    }

    private static final class Node {
        java.util.Map<Character, Node> children = new java.util.HashMap<>();
        boolean word;
    }
}
