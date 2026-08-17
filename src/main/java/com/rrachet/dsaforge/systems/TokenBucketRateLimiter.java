package com.rrachet.dsaforge.systems;

/** Thread-safe token-bucket rate limiter with nanosecond-based refill. */
public final class TokenBucketRateLimiter {
    private final long capacity;
    private final double refillPerSecond;
    private double tokens;
    private long lastRefillNanos;

    public TokenBucketRateLimiter(long capacity, double refillPerSecond) {
        if (capacity <= 0 || refillPerSecond <= 0) {
            throw new IllegalArgumentException("capacity and refill rate must be positive");
        }
        this.capacity = capacity;
        this.refillPerSecond = refillPerSecond;
        this.tokens = capacity;
        this.lastRefillNanos = System.nanoTime();
    }

    public synchronized boolean tryAcquire() {
        refill();
        if (tokens < 1.0) return false;
        tokens -= 1.0;
        return true;
    }

    public synchronized double availableTokens() {
        refill();
        return tokens;
    }

    private void refill() {
        long now = System.nanoTime();
        long elapsed = now - lastRefillNanos;
        if (elapsed <= 0) return;
        tokens = Math.min(capacity, tokens + elapsed / 1_000_000_000.0 * refillPerSecond);
        lastRefillNanos = now;
    }
}
