# Complexity Cheat Sheet

| Pattern | Time | Space | Notes |
| --- | --- | --- | --- |
| Two Pointers | O(n) | O(1) | Usually requires sorted data or monotonic constraint |
| Sliding Window | O(n) | O(1) ~ O(k) | Hash-based windows may need O(k) map |
| Binary Search | O(log n) | O(1) | Works on monotonic predicates |
| DFS/BFS | O(V+E) | O(V) | V: vertices, E: edges |
| DP | O(state) | O(state) | Consider state compression when transitions are local |
