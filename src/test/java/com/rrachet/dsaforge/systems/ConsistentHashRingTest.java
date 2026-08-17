package com.rrachet.dsaforge.systems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsistentHashRingTest {
    @Test void locatesKeysOnAvailableNodes() {
        ConsistentHashRing ring = new ConsistentHashRing(10);
        ring.addNode("node-a"); ring.addNode("node-b");
        assertTrue(ring.locate("customer-42").startsWith("node-"));
        assertEquals(20, ring.virtualNodeCount());
    }

    @Test void removingNodeRemovesVirtualNodes() {
        ConsistentHashRing ring = new ConsistentHashRing(5);
        ring.addNode("a"); ring.addNode("b");
        ring.removeNode("a");
        assertEquals(5, ring.virtualNodeCount());
        assertEquals("b", ring.locate("key"));
    }
}
