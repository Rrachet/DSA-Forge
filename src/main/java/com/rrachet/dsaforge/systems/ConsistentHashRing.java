package com.rrachet.dsaforge.systems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/** Consistent-hashing ring with virtual nodes to spread keys across servers. */
public final class ConsistentHashRing {
    private static final int DEFAULT_VIRTUAL_NODES = 100;
    private final NavigableMap<Long, String> ring = new TreeMap<>();
    private final int virtualNodes;

    public ConsistentHashRing() { this(DEFAULT_VIRTUAL_NODES); }

    public ConsistentHashRing(int virtualNodes) {
        if (virtualNodes <= 0) throw new IllegalArgumentException("virtualNodes must be positive");
        this.virtualNodes = virtualNodes;
    }

    public void addNode(String node) {
        for (int i = 0; i < virtualNodes; i++) ring.put(hash(node + "#" + i), node);
    }

    public void removeNode(String node) {
        for (int i = 0; i < virtualNodes; i++) ring.remove(hash(node + "#" + i));
    }

    public String locate(String key) {
        if (ring.isEmpty()) throw new IllegalStateException("no nodes available");
        Map.Entry<Long, String> entry = ring.ceilingEntry(hash(key));
        return entry != null ? entry.getValue() : ring.firstEntry().getValue();
    }

    public int virtualNodeCount() { return ring.size(); }

    private static long hash(String value) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
            long result = 0;
            for (int i = 0; i < 8; i++) result = (result << 8) | (digest[i] & 0xffL);
            return result & Long.MAX_VALUE;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
