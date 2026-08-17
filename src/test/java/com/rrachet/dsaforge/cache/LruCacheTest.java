package com.rrachet.dsaforge.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {
    @Test
    void evictsLeastRecentlyUsedEntry() {
        LruCache<Integer, String> cache = new LruCache<>(2);
        cache.put(1, "one");
        cache.put(2, "two");
        assertEquals("one", cache.get(1));

        cache.put(3, "three");

        assertNull(cache.get(2));
        assertEquals("one", cache.get(1));
        assertEquals("three", cache.get(3));
    }

    @Test
    void updatingAnEntryRefreshesItsRecency() {
        LruCache<String, Integer> cache = new LruCache<>(2);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("a", 10);
        cache.put("c", 3);

        assertEquals(10, cache.get("a"));
        assertNull(cache.get("b"));
        assertEquals(3, cache.get("c"));
    }

    @Test
    void rejectsNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new LruCache<>(0));
        assertThrows(IllegalArgumentException.class, () -> new LruCache<>(-1));
    }

    @Test
    void reportsCurrentSize() {
        LruCache<Integer, Integer> cache = new LruCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(2, cache.size());
    }
}
