package com.rrachet.dsaforge.queue;

/** Fixed-capacity circular queue with O(1) enqueue and dequeue. */
public final class CircularQueue {
    private final int[] data;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        data = new int[capacity];
    }

    public boolean offer(int value) {
        if (size == data.length) return false;
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException("queue is empty");
        int value = data[head];
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
