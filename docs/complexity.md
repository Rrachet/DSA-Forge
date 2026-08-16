# Complexity Guide

Big-O describes how resource usage scales with input size.

| Complexity | Typical example |
|---|---|
| O(1) | Array index lookup |
| O(log n) | Binary search |
| O(n) | Linear scan / frequency count |
| O(n log n) | Merge sort |
| O(n²) | Simple nested comparisons |
| O(2ⁿ) | Subset generation |

## Space complexity

Space should include auxiliary memory and, for recursive algorithms, call-stack depth. Output memory is called out separately when the algorithm intentionally materialises a result set.

## Practical rule

Do not optimise based on Big-O alone. Constant factors, cache locality, allocation behaviour, input distribution, and the Java runtime can change real-world performance. That is why DSA Forge includes JMH benchmarks alongside asymptotic analysis.
