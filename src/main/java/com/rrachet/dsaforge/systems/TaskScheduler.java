package com.rrachet.dsaforge.systems;

import java.util.Comparator;
import java.util.PriorityQueue;

/** Priority scheduler with FIFO ordering for tasks sharing the same priority. */
public final class TaskScheduler<T> {
    private final PriorityQueue<Task<T>> queue = new PriorityQueue<>(
            Comparator.<Task<T>>comparingInt(Task::priority).reversed()
                    .thenComparingLong(Task::sequence));
    private long sequence;

    public void submit(T value, int priority) {
        queue.offer(new Task<>(value, priority, sequence++));
    }

    public T next() {
        Task<T> task = queue.poll();
        return task == null ? null : task.value();
    }

    public int size() { return queue.size(); }

    private record Task<T>(T value, int priority, long sequence) {}
}
