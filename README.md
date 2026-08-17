# DSA Forge

> **An engineering-first Data Structures & Algorithms laboratory in Java.**

DSA Forge is a focused repository for understanding the algorithms and data structures that sit underneath real software systems. The goal is not to collect solutions. The goal is to implement, test, measure, and explain them well enough to discuss the engineering trade-offs in an interview.

## Why this repository exists

Strong software engineering starts with fundamentals. DSA Forge treats each topic as an engineering artifact:

- implement the data structure or algorithm from first principles
- state time and space complexity explicitly
- test boundary conditions and failure cases
- benchmark performance where measurement is meaningful
- document the pattern and when it should be used
- connect interview problems to real systems where appropriate

This makes the repository useful for **SWE interview preparation, algorithm study, and practical engineering discussion**.

## Core coverage

| Area | Examples |
|---|---|
| Arrays & searching | Binary search, two pointers, sliding window, prefix patterns |
| Strings | Trie, encoding/decoding, palindrome patterns |
| Linked lists | In-place reversal and pointer manipulation |
| Stack & queue | Circular queue, monotonic stack, parentheses validation |
| Hashing | Frequency counting and lookup patterns |
| Cache design | **O(1) LRU cache** using hash map + doubly linked list |
| Trees | Binary search tree and traversal patterns |
| Heaps | Top-K and priority-queue patterns |
| Graphs | BFS, DFS, Union-Find, Dijkstra, topological sorting |
| Sorting | Merge sort, quick sort |
| Backtracking | Subset generation |
| Greedy | Activity selection |
| Dynamic programming | Knapsack, coin change, house robber, climbing stairs |

## Engineering tracks

### 1. Algorithm fundamentals

Reusable implementations organised by data structure and algorithmic pattern. Every implementation should have an explicit complexity target and meaningful tests.

### 2. Systems-oriented data structures

The repository deliberately includes structures that appear in real services, not only textbook exercises. The current example is an **LRU cache** with O(1) average `get` and `put` operations.

That implementation combines two structures with complementary strengths:

```text
HashMap<K, Node>        -> O(1) average lookup
Doubly linked list      -> O(1) recency updates
             |
             v
        O(1) LRU cache
```

### 3. Interview pattern track

### [100-Problem Interview Catalogue](docs/interview-100/catalogue.md)

100 selected problems across 10 patterns, progressing from foundation to advanced interview level. A problem is only considered complete when implementation, meaningful tests, and complexity analysis exist.

The track is designed around **pattern recognition, correctness, and communication**, not solution-count chasing.

## Performance engineering

JMH benchmarks live under `benchmarks/` and are intentionally separated from correctness tests.

The benchmark workflow is:

```text
Hypothesis
   ↓
Implementation
   ↓
Correctness tests
   ↓
Benchmark
   ↓
Interpretation
```

Benchmark numbers should be measured rather than copied into documentation. When a benchmark is added, record the input shape, environment, and what the result actually demonstrates.

## Project structure

```text
src/main/java/com/rrachet/dsaforge/
├── arrays/
├── backtracking/
├── cache/
├── dynamicprogramming/
├── graphs/
├── hashing/
├── heaps/
├── linkedlist/
├── queue/
├── recursion/
├── sorting/
├── stack/
├── strings/
└── trees/

src/test/java/com/rrachet/dsaforge/
benchmarks/
docs/
├── algorithms.md
├── complexity.md
├── patterns.md
└── interview-100/
.github/workflows/
```

## Run locally

Requires **Java 21** and Maven.

Run the complete test suite:

```bash
mvn clean test
```

Build the project:

```bash
mvn clean package
```

## Engineering standards

1. Prefer clear implementations before clever optimisations.
2. State time and space complexity for non-trivial algorithms.
3. Test empty, singleton, boundary, duplicate, and invalid inputs where applicable.
4. Keep APIs small and deterministic where possible.
5. Use the standard library when it is the right engineering choice, while implementing core structures to understand their internals.
6. Separate correctness testing from performance measurement.
7. Never claim benchmark results without actually measuring them.
8. Explain trade-offs, not just final answers.

## Roadmap

- [x] Core algorithm catalogue
- [x] Automated unit tests
- [x] Complexity documentation
- [x] Pattern catalogue
- [x] Initial JMH benchmark suite
- [x] 100-problem interview catalogue
- [x] Trie
- [x] Union-Find / Disjoint Set
- [x] Topological sorting
- [x] Dijkstra and shortest paths
- [x] Sliding window catalogue
- [x] Monotonic stack catalogue
- [x] O(1) LRU cache
- [ ] Complete the remaining interview-track solutions incrementally
- [ ] Segment tree
- [ ] Advanced dynamic programming
- [ ] More systems-oriented structures: LFU cache, bounded queue, rate limiter
- [ ] Expand benchmark coverage and publish reproducible results

## License

MIT
