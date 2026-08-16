package com.rrachet.dsaforge.linkedlist;

/** Merges two sorted linked lists in-place. Time O(n+m), space O(1). */
public final class MergeSortedLists {
    private MergeSortedLists() {}
    public static ReverseLinkedList.Node merge(ReverseLinkedList.Node a, ReverseLinkedList.Node b) {
        ReverseLinkedList.Node dummy = new ReverseLinkedList.Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.value <= b.value) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = a != null ? a : b;
        return dummy.next;
    }
}
