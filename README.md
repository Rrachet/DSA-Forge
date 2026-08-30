# DSA Forge

> **Engineering-first Data Structures & Algorithms laboratory in Java.**

DSA Forge is the computer-science fundamentals layer of my portfolio. It demonstrates the reasoning behind systems that appear in real applications: caching, rate limiting, queues, scheduling and distributed key placement.

## Why it matters

Application support is not only about clicking through procedures. Strong support engineers need to reason about application behaviour, bottlenecks and failure modes. DSA Forge demonstrates that underlying problem-solving foundation.

## Systems track

| Component | Real-world concept | Target complexity |
|---|---|---|
| LRU Cache | Bounded caching | O(1) average get/put |
| LFU Cache | Frequency-based eviction | O(1) average get/put |
| Token Bucket | Rate limiting | O(1) acquire |
| Bounded Blocking Queue | Backpressure / producer-consumer | O(1) queue operations |
| Consistent Hash Ring | Distributed key placement | O(log V) lookup |
| Task Scheduler | Priority scheduling | O(log n) submit/next |

These are intentionally small implementations for understanding system primitives, not replacements for production infrastructure such as Redis or Kafka.

## Algorithm coverage

Arrays · Strings · Linked Lists · Stacks · Queues · Hashing · Trees · Heaps · Graphs · Sorting · Backtracking · Greedy · Dynamic Programming · Tries · Union-Find · Shortest Paths

## Testing + benchmarking

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

Benchmark results are intended to be reproduced rather than copied into documentation.

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

```bash
mvn clean test
mvn clean package
```

## Engineering standards

1. Prefer clarity before clever optimisation.
2. State time and space complexity for non-trivial algorithms.
3. Test boundary and invalid inputs where applicable.
4. Keep APIs small and deterministic.
5. Separate correctness tests from performance measurement.
6. Never claim benchmark results without measuring them.
7. Explain trade-offs, not just final answers.

## Portfolio role

**FUNDAMENTALS — Java + systems reasoning**

DSA Forge supports the IBM-focused portfolio by demonstrating the computer-science depth behind application troubleshooting and software engineering. It complements [LaunchPad](https://github.com/Rrachet/LaunchPad), [APIAtlas](https://github.com/Rrachet/apiatlas) and [SupportHub](https://github.com/Rrachet/SupportHub).

## License

MIT
