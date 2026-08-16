package com.rrachet.dsaforge.linkedlist;

/** Floyd's tortoise-and-hare cycle detection. Time O(n), space O(1). */
public final class LinkedListCycle {
    private LinkedListCycle() {}
    public static boolean hasCycle(ReverseLinkedList.Node head) {
        ReverseLinkedList.Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
