package com.rrachet.dsaforge.trees;

import com.rrachet.dsaforge.heaps.KthLargest;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TreeAndHeapTest {
    @Test void bstSearchesAndProducesSortedTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{5,3,7,2,4,6,8}) tree.insert(value);
        assertTrue(tree.contains(6));
        assertFalse(tree.contains(10));
        assertEquals(List.of(2,3,4,5,6,7,8), tree.inOrder());
    }

    @Test void kthLargestUsesExpectedHeapResult() {
        assertEquals(5, KthLargest.find(new int[]{3,2,1,5,6,4}, 2));
        assertThrows(IllegalArgumentException.class, () -> KthLargest.find(new int[]{1}, 2));
    }
}
