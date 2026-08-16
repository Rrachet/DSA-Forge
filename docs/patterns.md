# Problem-Solving Patterns

## Binary Search

Use when the search space is ordered or can be made monotonic. Maintain an invariant describing what remains possible.

## Two Pointers

Use when two indices can move through a sequence while preserving a useful relationship. Common for sorted arrays and palindrome-style problems.

## Hashing

Use a hash map/set when constant-average lookup can replace repeated scanning. Two Sum and frequency counting are canonical examples.

## Sliding Window

Maintain a moving interval for contiguous-subarray or substring constraints. Expand until a constraint breaks, then shrink while restoring it.

## Stack / Monotonic Stack

Stacks model nested structure and nearest-previous/next relationships. A monotonic stack can reduce many nearest-element problems from O(n²) to O(n).

## Heap / Top-K

A bounded heap is useful when only the best k elements matter. Maintaining a min-heap of size k gives O(n log k) for top-k selection.

## BFS / DFS

BFS is natural for shortest paths in unweighted graphs and level-order exploration. DFS is natural for exhaustive traversal, connected components, and recursive decomposition.

## Greedy

Make the locally optimal choice only when the problem has a proof that the choice preserves global optimality. Activity selection is a classic exchange-argument example.

## Dynamic Programming

Identify overlapping subproblems and optimal substructure. Define a state, transition, base case, and iteration order before writing code.

## Backtracking

Build a candidate incrementally, recurse, then undo the choice. The key is defining a correct state and pruning impossible branches when possible.
