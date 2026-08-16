package com.rrachet.dsaforge;

import com.rrachet.dsaforge.arrays.*;
import com.rrachet.dsaforge.dynamicprogramming.*;
import com.rrachet.dsaforge.heaps.*;
import com.rrachet.dsaforge.linkedlist.*;
import com.rrachet.dsaforge.stack.*;
import com.rrachet.dsaforge.searching.*;
import com.rrachet.dsaforge.trees.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MoreAlgorithmsTest {
    @Test void arrayPatterns() {
        assertEquals(5, BestTimeToBuySellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(6, MaximumSubarray.maxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(List.of("2#hi5#hello"), List.of(EncodeDecodeStrings.encode(List.of("hi","hello"))));
        assertEquals(List.of(List.of(-1,-1,2), List.of(-1,0,1)), ThreeSum.find(new int[]{-1,0,1,2,-1,-4}));
        assertEquals(49, ContainerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(4, LongestConsecutiveSequence.length(new int[]{100,4,200,1,3,2}));
    }

    @Test void stackAndSearchPatterns() {
        MinStack stack = new MinStack(); stack.push(3); stack.push(1); stack.push(2); assertEquals(1, stack.min()); stack.pop(); assertEquals(1, stack.min());
        assertEquals(9, EvaluateReversePolishNotation.evaluate(new String[]{"2","1","+","3","*"}));
        assertEquals(2, SearchInsertPosition.find(new int[]{1,3,5,6}, 5));
        assertEquals(4, SearchInsertPosition.find(new int[]{1,3,5,6}, 7));
        assertEquals(4, SearchInRotatedSortedArray.find(new int[]{4,5,6,7,0,1,2}, 0));
    }

    @Test void linkedListAndTrees() {
        var a = new ReverseLinkedList.Node(1); a.next = new ReverseLinkedList.Node(3);
        var b = new ReverseLinkedList.Node(2); b.next = new ReverseLinkedList.Node(4);
        var merged = MergeSortedLists.merge(a,b); assertEquals(1, merged.value); assertEquals(2, merged.next.value); assertEquals(3, merged.next.next.value);
        var cyclic = new ReverseLinkedList.Node(1); cyclic.next = new ReverseLinkedList.Node(2); cyclic.next.next = cyclic; assertTrue(LinkedListCycle.hasCycle(cyclic));
        var root = new TreeNode(1); root.left = new TreeNode(2); root.right = new TreeNode(3); root.left.left = new TreeNode(4);
        assertEquals(3, MaximumDepth.of(root)); assertEquals(List.of(List.of(1),List.of(2,3),List.of(4)), LevelOrderTraversal.traverse(root));
        InvertBinaryTree.invert(root); assertEquals(3, root.left.value);
    }

    @Test void heapsAndDp() {
        assertEquals(1, LastStoneWeight.remaining(new int[]{2,7,4,1,8,1}));
        assertEquals(2, KClosestPoints.find(new int[][]{{1,3},{-2,2},{5,8}}, 1)[0][0]);
        assertEquals(8, ClimbingStairs.ways(5));
        assertEquals(12, HouseRobber.max(new int[]{2,7,9,3,1}));
        assertEquals(3, CoinChange.minCoins(new int[]{1,2,5}, 11));
    }
}
