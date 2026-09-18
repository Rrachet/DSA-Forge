# DSA-Forge

### Data Structures & Algorithms laboratory in Java

DSA-Forge is the computer-science fundamentals layer of my portfolio. It focuses on implementing algorithms and reusable systems primitives while making **correctness, complexity and trade-offs** explicit.

## Coverage

Arrays · Strings · Linked Lists · Stacks · Queues · Hashing · Trees · Heaps · Graphs · Sorting · Backtracking · Greedy · Dynamic Programming · Tries · Union-Find · Shortest Paths

## Systems primitives

| Component | Engineering concept | Target complexity |
|---|---|---|
| LRU Cache | Bounded caching | O(1) average get/put |
| LFU Cache | Frequency-based eviction | O(1) average get/put |
| Token Bucket | Rate limiting | O(1) acquire |
| Bounded Blocking Queue | Producer/consumer + backpressure | O(1) queue operations |
| Consistent Hash Ring | Distributed key placement | O(log V) lookup |
| Task Scheduler | Priority scheduling | O(log n) submit/next |

These are learning implementations designed to expose the underlying mechanics of common systems primitives.

## Testing + benchmarking

```text
PROBLEM
  ↓
IMPLEMENTATION
  ↓
CORRECTNESS TESTS
  ↓
BENCHMARK
  ↓
INTERPRET RESULTS
```

The repository separates correctness testing from performance measurement and documents time/space complexity for non-trivial implementations.

## Repository structure

```text
src/main/java/          implementations
src/test/java/          automated tests
benchmarks/             JMH benchmarks
docs/                   complexity + patterns
.github/workflows/      CI
```

## Run

Requires Java 21 + Maven.

```bash
mvn clean test
mvn clean package
```

## Engineering standards

1. Prefer clarity before clever optimisation.
2. State time and space complexity.
3. Test boundary and invalid inputs.
4. Keep APIs small and deterministic.
5. Separate correctness tests from benchmarks.
6. Measure before making performance claims.
7. Explain trade-offs, not just final answers.

## Portfolio role

**COMPUTER SCIENCE FUNDAMENTALS — Java, algorithms, complexity and systems reasoning**

[Source](https://github.com/Rrachet/DSA-Forge)

## License

MIT
