package com.rrachet.dsaforge.systems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundedBlockingQueueTest {
    @Test void preservesFifoOrder() throws InterruptedException {
        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(2);
        queue.put(1); queue.put(2);
        assertEquals(1, queue.take());
        assertEquals(2, queue.take());
    }

    @Test void validatesCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedBlockingQueue<>(0));
    }
}
