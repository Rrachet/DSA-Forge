package com.rrachet.dsaforge.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {
    @Test void supportsRangeQueriesAndUpdates() {
        SegmentTree tree = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11});
        assertEquals(15, tree.rangeSum(1, 3));
        tree.update(2, 10);
        assertEquals(18, tree.rangeSum(1, 3));
    }

    @Test void rejectsInvalidRanges() {
        SegmentTree tree = new SegmentTree(new int[]{1, 2});
        assertThrows(IndexOutOfBoundsException.class, () -> tree.rangeSum(1, 0));
    }
}
