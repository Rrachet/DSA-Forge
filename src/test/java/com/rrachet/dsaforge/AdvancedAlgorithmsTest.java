package com.rrachet.dsaforge;

import com.rrachet.dsaforge.backtracking.Subsets;
import com.rrachet.dsaforge.dynamicprogramming.Knapsack01;
import com.rrachet.dsaforge.graphs.GraphTraversal;
import com.rrachet.dsaforge.greedy.ActivitySelection;
import com.rrachet.dsaforge.hashing.FrequencyCounter;
import com.rrachet.dsaforge.recursion.Factorial;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class AdvancedAlgorithmsTest {
    @Test void frequencyCounting() {
        assertEquals(Map.of(2, 2, 3, 1), FrequencyCounter.count(new int[]{2,3,2}));
    }

    @Test void graphTraversalVisitsReachableNodes() {
        Map<Integer,List<Integer>> graph = Map.of(1,List.of(2,3), 2,List.of(4), 3,List.of(), 4,List.of());
        assertEquals(List.of(1,2,3,4), GraphTraversal.bfs(graph, 1));
        assertEquals(List.of(1,2,4,3), GraphTraversal.dfs(graph, 1));
    }

    @Test void recursionBacktrackingGreedyAndDp() {
        assertEquals(120, Factorial.of(5));
        assertEquals(8, Subsets.generate(new int[]{1,2,3}).size());
        assertEquals(3, ActivitySelection.maximum(new ActivitySelection.Activity[]{
                new ActivitySelection.Activity(1,2), new ActivitySelection.Activity(2,3), new ActivitySelection.Activity(3,4), new ActivitySelection.Activity(1,4)}));
        assertEquals(7, Knapsack01.maxValue(new int[]{1,3,4}, new int[]{2,5,7}, 4));
    }
}
