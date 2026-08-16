package com.rrachet.dsaforge;

import com.rrachet.dsaforge.arrays.SlidingWindowMaximum;
import com.rrachet.dsaforge.graphs.Dijkstra;
import com.rrachet.dsaforge.graphs.TopologicalSort;
import com.rrachet.dsaforge.graphs.UnionFind;
import com.rrachet.dsaforge.stack.NextGreaterElement;
import com.rrachet.dsaforge.strings.Trie;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class GraphAndPatternTest {
    @Test void slidingWindowAndMonotonicStack() {
        assertArrayEquals(new int[]{3,3,5,5,6,7}, SlidingWindowMaximum.find(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        assertArrayEquals(new int[]{4,2,4,-1}, NextGreaterElement.find(new int[]{2,1,2,4}));
    }

    @Test void trieSupportsWordsAndPrefixes() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.contains("apple"));
        assertFalse(trie.contains("app"));
        assertTrue(trie.startsWith("app"));
    }

    @Test void unionFindConnectsComponents() {
        UnionFind uf = new UnionFind(4);
        assertTrue(uf.union(0,1));
        assertTrue(uf.union(1,2));
        assertFalse(uf.union(0,2));
        assertEquals(uf.find(0), uf.find(2));
        assertNotEquals(uf.find(0), uf.find(3));
    }

    @Test void dijkstraFindsShortestPaths() {
        Map<Integer,List<Dijkstra.Edge>> graph = Map.of(
                0, List.of(new Dijkstra.Edge(1,4), new Dijkstra.Edge(2,1)),
                2, List.of(new Dijkstra.Edge(1,2)), 1, List.of());
        assertEquals(3L, Dijkstra.shortestPaths(graph, 0).get(1));
    }

    @Test void topologicalSortOrdersDependencies() {
        Map<Integer,List<Integer>> graph = Map.of(5,List.of(2,0), 4,List.of(0,1), 2,List.of(3), 3,List.of(1), 0,List.of(), 1,List.of());
        List<Integer> order = TopologicalSort.sort(graph);
        assertEquals(6, order.size());
        assertTrue(order.indexOf(5) < order.indexOf(2));
        assertTrue(order.indexOf(2) < order.indexOf(3));
        assertTrue(order.indexOf(4) < order.indexOf(1));
    }
}
