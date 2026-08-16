package com.rrachet.dsaforge.linkedlist;

/** Iterative singly linked-list reversal. Time O(n), space O(1). */
public final class ReverseLinkedList {
    private ReverseLinkedList() {}

    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static final class Node {
        public final int value;
        public Node next;
        public Node(int value) { this.value = value; }
    }
}
