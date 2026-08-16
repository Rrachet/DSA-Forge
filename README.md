# DSA Forge

> **A production-grade Data Structures & Algorithms laboratory in Java.**

DSA Forge is not a dump of LeetCode answers. It is a structured study and engineering repository covering reusable data structures, algorithmic patterns, complexity analysis, automated tests, performance benchmarks, and continuous integration.

## What this repository demonstrates

- Core data structures implemented from first principles
- Algorithmic problem-solving patterns
- Big-O analysis for every implementation
- Edge-case driven JUnit 5 tests
- JMH performance benchmarks
- Maven project structure
- GitHub Actions CI
- Clear JavaDoc and engineering documentation

## Coverage

| Area | Included |
|---|---|
| Arrays & searching | Binary search, two pointers, prefix-style techniques |
| Strings | Palindrome and frequency patterns |
| Linked lists | Reversal and pointer manipulation |
| Stack & queue | Parentheses validation and queue fundamentals |
| Hashing | Frequency counting and lookup |
| Trees | Binary search tree operations |
| Heaps | Top-K / priority-queue patterns |
| Graphs | BFS and DFS |
| Sorting | Merge sort and quick sort |
| Recursion | Factorial and recursive decomposition |
| Backtracking | Subset generation |
| Greedy | Activity selection |
| Dynamic programming | 0/1 knapsack |

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
├── arrays/
├── strings/
├── linkedlist/
├── stack/
├── trees/
└── sorting/

benchmarks/
docs/
.github/workflows/
```

## Run locally

```bash
mvn clean test
```

Run the packaged application build:

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
- [ ] Tries
- [ ] Union-Find / Disjoint Set
- [ ] Topological sorting
- [ ] Dijkstra and shortest paths
- [ ] Sliding window catalogue
- [ ] Monotonic stack catalogue
- [ ] Segment tree
- [ ] Advanced dynamic programming

## License

MIT
