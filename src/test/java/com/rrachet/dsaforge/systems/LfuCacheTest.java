package com.rrachet.dsaforge.systems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LfuCacheTest {
    @Test void evictsLeastFrequentlyUsed() {
        LfuCache<Integer, String> cache = new LfuCache<>(2);
        cache.put(1, "a"); cache.put(2, "b");
        assertEquals("a", cache.get(1));
        cache.put(3, "c");
        assertEquals("a", cache.get(1));
        assertNull(cache.get(2));
        assertEquals("c", cache.get(3));
    }

    @Test void equalFrequencyUsesRecency() {
        LfuCache<Integer, String> cache = new LfuCache<>(2);
        cache.put(1, "a"); cache.put(2, "b");
        cache.put(3, "c");
        assertNull(cache.get(1));
        assertEquals("b", cache.get(2));
    }
}
