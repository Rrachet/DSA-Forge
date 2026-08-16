package com.rrachet.dsaforge.problems;

import com.rrachet.dsaforge.problems.arrayshashing.*;
import com.rrachet.dsaforge.problems.arraystwoPointers.*;
import com.rrachet.dsaforge.problems.slidingwindow.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class InterviewProblemsTest {
    @Test void arraysAndHashing() {
        assertFalse(ContainsDuplicate.solve(new int[]{1,2,3,4}));
        assertTrue(ContainsDuplicate.solve(new int[]{1,2,3,1}));
        assertTrue(ValidAnagram.solve("anagram", "nagaram"));
        assertFalse(ValidAnagram.solve("rat", "car"));
        assertEquals(2, GroupAnagrams.solve(new String[]{"eat","tea","tan","ate","nat","bat"}).size());
        assertArrayEquals(new int[]{1,2}, TopKFrequent.solve(new int[]{1,1,1,2,2,3}, 2));
        assertArrayEquals(new int[]{24,12,8,6}, ProductExceptSelf.solve(new int[]{1,2,3,4}));
        assertEquals(4, LongestConsecutiveSequence.solve(new int[]{100,4,200,1,3,2}));
    }

    @Test void twoPointersAndSlidingWindow() {
        assertArrayEquals(new int[]{0,1}, TwoSumSorted.solve(new int[]{2,7,11,15}, 9));
        assertEquals(List.of(List.of(-1,-1,2), List.of(-1,0,1)), ThreeSum.solve(new int[]{-1,0,1,2,-1,-4}));
        assertEquals(49, ContainerWithMostWater.solve(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(5, BestTimeToBuySellStock.solve(new int[]{7,1,5,3,6,4}));
        assertEquals(3, LongestSubstringWithoutRepeating.solve("abcabcbb"));
        assertEquals(1, LongestSubstringWithoutRepeating.solve("bbbbb"));
    }
}
