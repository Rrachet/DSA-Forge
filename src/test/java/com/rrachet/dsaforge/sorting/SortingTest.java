package com.rrachet.dsaforge.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {
    @Test void mergeSortHandlesDuplicatesAndNegatives() {
        int[] values = {5,-1,3,3,0,8,-4};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{-4,-1,0,3,3,5,8}, values);
    }

    @Test void quickSortHandlesEmptyAndSingleElement() {
        int[] empty = {};
        QuickSort.sort(empty);
        assertArrayEquals(new int[]{}, empty);
        int[] one = {42};
        QuickSort.sort(one);
        assertArrayEquals(new int[]{42}, one);
    }
}
