package com.rrachet.dsaforge.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayAlgorithmsTest {
    @Test void binarySearchFindsAndRejectsTargets() {
        assertEquals(3, BinarySearch.find(new int[]{1,3,5,7,9}, 7));
        assertEquals(-1, BinarySearch.find(new int[]{1,3,5,7,9}, 6));
        assertEquals(-1, BinarySearch.find(new int[]{}, 6));
    }

    @Test void twoSumHandlesDuplicatesAndMissingPairs() {
        assertArrayEquals(new int[]{0,1}, TwoSum.find(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{}, TwoSum.find(new int[]{1,2,3}, 99));
    }
}
