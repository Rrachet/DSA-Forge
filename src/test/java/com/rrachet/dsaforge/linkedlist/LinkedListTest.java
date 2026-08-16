package com.rrachet.dsaforge.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Test void reverseHandlesMultiNodeAndEmptyLists() {
        var a = new ReverseLinkedList.Node(1);
        a.next = new ReverseLinkedList.Node(2);
        a.next.next = new ReverseLinkedList.Node(3);
        var head = ReverseLinkedList.reverse(a);
        assertEquals(3, head.value);
        assertEquals(2, head.next.value);
        assertEquals(1, head.next.next.value);
        assertNull(head.next.next.next);
        assertNull(ReverseLinkedList.reverse(null));
    }
}
