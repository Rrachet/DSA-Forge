package com.rrachet.dsaforge.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Fixed-capacity LRU cache with O(1) average get and put operations.
 *
 * @param <K> key type
 * @param <V> value type
 */
public final class LruCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> entries = new HashMap<>();
    private final Node<K, V> head = new Node<>(null, null);
    private final Node<K, V> tail = new Node<>(null, null);

    public LruCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public V get(K key) {
        Node<K, V> node = entries.get(key);
        if (node == null) return null;
        moveToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> existing = entries.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        Node<K, V> node = new Node<>(key, value);
        entries.put(key, node);
        addAfterHead(node);

        if (entries.size() > capacity) {
            Node<K, V> leastRecentlyUsed = tail.previous;
            remove(leastRecentlyUsed);
            entries.remove(leastRecentlyUsed.key);
        }
    }

    public int size() {
        return entries.size();
    }

    private void moveToFront(Node<K, V> node) {
        remove(node);
        addAfterHead(node);
    }

    private void addAfterHead(Node<K, V> node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    private void remove(Node<K, V> node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private static final class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> previous;
        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
