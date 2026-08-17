package com.rrachet.dsaforge.systems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenBucketRateLimiterTest {
    @Test void startsFullAndRejectsWhenEmpty() {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(2, 0.001);
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
    }

    @Test void validatesConfiguration() {
        assertThrows(IllegalArgumentException.class, () -> new TokenBucketRateLimiter(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TokenBucketRateLimiter(1, 0));
    }
}
