package com.rrachet.dsaforge.systems;

import java.util.HashMap;
import java.util.Map;

/**
 * Fixed-capacity LFU cache with LRU tie-breaking.
 * Average O(1) get/put and eviction.
 */
public final class LfuCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> nodes = new HashMap<>();
    private final Map<Integer, Bucket<K, V>> frequencies = new HashMap<>();
    private int minFrequency;

    public LfuCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.capacity = capacity;
    }

    public V get(K key) {
        Node<K, V> node = nodes.get(key);
        if (node == null) return null;
        touch(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> existing = nodes.get(key);
        if (existing != null) {
            existing.value = value;
            touch(existing);
            return;
        }
        if (nodes.size() == capacity) evict();
        Node<K, V> node = new Node<>(key, value);
        nodes.put(key, node);
        minFrequency = 1;
        frequencies.computeIfAbsent(1, ignored -> new Bucket<>()).addFirst(node);
    }

    public int size() { return nodes.size(); }

    private void touch(Node<K, V> node) {
        Bucket<K, V> old = frequencies.get(node.frequency);
        old.remove(node);
        if (node.frequency == minFrequency && old.isEmpty()) minFrequency++;
        node.frequency++;
        frequencies.computeIfAbsent(node.frequency, ignored -> new Bucket<>()).addFirst(node);
    }

    private void evict() {
        Bucket<K, V> bucket = frequencies.get(minFrequency);
        Node<K, V> victim = bucket.removeLast();
        nodes.remove(victim.key);
    }

    private static final class Node<K, V> {
        final K key;
        V value;
        int frequency = 1;
        Node<K, V> prev, next;
        Node(K key, V value) { this.key = key; this.value = value; }
    }

    private static final class Bucket<K, V> {
        final Node<K, V> head = new Node<>(null, null);
        final Node<K, V> tail = new Node<>(null, null);
        Bucket() { head.next = tail; tail.prev = head; }
        void addFirst(Node<K, V> node) {
            node.next = head.next; node.prev = head;
            head.next.prev = node; head.next = node;
        }
        void remove(Node<K, V> node) { node.prev.next = node.next; node.next.prev = node.prev; }
        Node<K, V> removeLast() { Node<K, V> node = tail.prev; remove(node); return node; }
        boolean isEmpty() { return head.next == tail; }
    }
}
