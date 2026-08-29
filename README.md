# DSA Forge

> **An engineering-first Data Structures & Algorithms laboratory in Java.**

DSA Forge is built around a simple idea: don't just solve problems — **implement, test, measure and explain the engineering trade-offs behind them.**

[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)](https://www.java.com/) [![Build](https://img.shields.io/badge/Build-Maven-blue?style=flat-square&logo=apachemaven)](https://maven.apache.org/)

## What this demonstrates

- Strong algorithmic fundamentals
- Complexity analysis
- Boundary and failure-case testing
- Systems-oriented data structures
- Performance benchmarking with JMH
- Clear engineering documentation

## Systems track

| Component | Real-world concept | Target complexity |
|---|---|---|
| LRU Cache | Bounded caching | O(1) average get/put |
| LFU Cache | Frequency-based eviction | O(1) average get/put |
| Token Bucket | Rate limiting | O(1) acquire |
| Bounded Blocking Queue | Backpressure / producer-consumer | O(1) queue operations |
| Consistent Hash Ring | Distributed key placement | O(log V) lookup |
| Task Scheduler | Priority scheduling | O(log n) submit/next |

These are intentionally small implementations for understanding the primitives underneath larger systems — not replacements for production infrastructure such as Redis or Kafka.

## Algorithm coverage

Arrays · Strings · Linked Lists · Stacks · Queues · Hashing · Trees · Heaps · Graphs · Sorting · Backtracking · Greedy · Dynamic Programming · Tries · Union-Find · Shortest Paths

## Systems in one picture

```text
Application
    │
    ├── Cache ───────────── LRU / LFU
    │
    ├── Admission Control ─ Token Bucket
    │
    ├── Work Queue ──────── Bounded Queue
    │
    ├── Scheduling ──────── Priority Scheduler
    │
    └── Distribution ────── Consistent Hashing
```

## Testing + benchmarking

Correctness and performance are intentionally separate:

```text
Hypothesis
   ↓
Implementation
   ↓
Correctness tests
   ↓
JMH benchmark
   ↓
Interpretation
```

Benchmark results should be reproduced rather than copied into documentation.

## Repository structure

```text
src/main/java/          implementations
src/test/java/          automated tests
benchmarks/             JMH benchmarks
docs/                   complexity + patterns
.github/workflows/      CI
```

## Run locally

Requires **Java 21 + Maven**.

Run tests:

```bash
mvn clean test
```

Build:

```bash
mvn clean package
```

## Engineering standards

1. Prefer clarity before clever optimisation.
2. State time and space complexity for non-trivial algorithms.
3. Test empty, singleton, boundary, duplicate, concurrent and invalid inputs where applicable.
4. Keep APIs small and deterministic.
5. Separate correctness tests from performance measurement.
6. Never claim benchmark results without measuring them.
7. Explain trade-offs, not just final answers.

## Roadmap

- [x] Core algorithm catalogue
- [x] Automated unit tests
- [x] Complexity documentation
- [x] Pattern catalogue
- [x] JMH benchmark suite
- [x] Systems-oriented data structures
- [ ] Complete remaining interview-track solutions
- [ ] Segment tree
- [ ] Advanced dynamic programming
- [ ] Expand reproducible benchmark coverage

## Product + engineering signal

DSA Forge is the fundamentals layer of my portfolio: it demonstrates the computer-science depth I bring into larger product and software systems.

## License

MIT
