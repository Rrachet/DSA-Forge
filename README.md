# DSA Forge

> **A production-grade Data Structures & Algorithms laboratory in Java.**

DSA Forge is not a dump of LeetCode answers. It is a structured engineering repository covering reusable data structures, algorithmic patterns, complexity analysis, automated tests, performance benchmarks, and continuous integration.

## What this repository demonstrates

- Core data structures implemented from first principles
- Algorithmic problem-solving patterns
- Big-O analysis for every implementation
- Edge-case driven JUnit 5 tests
- JMH performance benchmarks
- Maven project structure
- GitHub Actions CI
- Clear JavaDoc and engineering documentation
- A curated 100-problem interview track organised by pattern

## Coverage

| Area | Included |
|---|---|
| Arrays & searching | Binary search, two pointers, sliding window |
| Strings | Palindrome validation, Trie |
| Linked lists | In-place reversal |
| Stack & queue | Parentheses validation, circular queue, monotonic stack |
| Hashing | Frequency counting |
| Trees | Binary search tree |
| Heaps | Top-K / priority-queue pattern |
| Graphs | BFS, DFS, Union-Find, Dijkstra, topological sorting |
| Sorting | Merge sort, quick sort |
| Recursion | Factorial |
| Backtracking | Subset generation |
| Greedy | Activity selection |
| Dynamic programming | 0/1 knapsack |

## Interview track

### [100-Problem Interview Catalogue](docs/interview-100/catalogue.md)

100 carefully selected problems across 10 patterns, progressing from foundation to advanced interview level. A problem is only considered complete when implementation, meaningful tests, and complexity analysis exist.

The track is designed to demonstrate **pattern recognition and engineering discipline**, not solution-count chasing.

## Project structure

```text
src/main/java/com/rrachet/dsaforge/
├── arrays/
├── strings/
├── linkedlist/
├── stack/
├── queue/
├── hashing/
├── trees/
├── heaps/
├── graphs/
├── sorting/
├── recursion/
├── backtracking/
├── greedy/
└── dynamicprogramming/

src/test/java/com/rrachet/dsaforge/
benchmarks/
docs/
└── interview-100/
.github/workflows/
```

## Run locally

```bash
mvn clean test
```

Build the project:

```bash
mvn clean package
```

## Benchmarking

JMH benchmark sources live under `benchmarks/`. They are intentionally separated from correctness tests so performance measurement does not become part of the normal CI test cycle.

## Engineering principles

1. Prefer readable algorithms before clever micro-optimisations.
2. State time and space complexity explicitly.
3. Test boundary conditions, not only happy paths.
4. Keep implementations deterministic where possible.
5. Use the Java standard library when it is the correct engineering choice, while also implementing core structures to understand their internals.

## Roadmap

- [x] Core algorithm catalogue
- [x] Automated unit tests
- [x] CI workflow
- [x] Complexity documentation
- [x] Pattern catalogue
- [x] Initial JMH benchmark suite
- [x] 100-problem interview catalogue
- [x] Tries
- [x] Union-Find / Disjoint Set
- [x] Topological sorting
- [x] Dijkstra and shortest paths
- [x] Sliding window catalogue
- [x] Monotonic stack catalogue
- [ ] Implement the remaining interview-track solutions incrementally
- [ ] Segment tree
- [ ] Advanced dynamic programming

## License

MIT
