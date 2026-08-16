package com.rrachet.dsaforge.linkedlist;

/** Removes the nth node from the end using two pointers. Time O(n), space O(1). */
public final class RemoveNthFromEnd {
    private RemoveNthFromEnd() {}
    public static ReverseLinkedList.Node remove(ReverseLinkedList.Node head, int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        ReverseLinkedList.Node dummy = new ReverseLinkedList.Node(0); dummy.next = head;
        ReverseLinkedList.Node fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) { if (fast.next == null) throw new IllegalArgumentException("n exceeds length"); fast = fast.next; }
        while (fast.next != null) { fast = fast.next; slow = slow.next; }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
