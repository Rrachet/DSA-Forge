package com.rrachet.dsaforge.stack;

import com.rrachet.dsaforge.queue.CircularQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackAndQueueTest {
    @Test void parenthesesValidationCoversNesting() {
        assertTrue(ValidParentheses.check("([]{})"));
        assertFalse(ValidParentheses.check("([)]"));
        assertFalse(ValidParentheses.check("("));
    }

    @Test void circularQueueWrapsAround() {
        CircularQueue queue = new CircularQueue(2);
        assertTrue(queue.offer(10));
        assertTrue(queue.offer(20));
        assertFalse(queue.offer(30));
        assertEquals(10, queue.poll());
        assertTrue(queue.offer(30));
        assertEquals(20, queue.poll());
        assertEquals(30, queue.poll());
        assertTrue(queue.isEmpty());
    }
}
