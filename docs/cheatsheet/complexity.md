# Complexity Cheat Sheet

| Pattern | Time | Space | Notes |
| --- | --- | --- | --- |
| Two Pointers | O(n) | O(1) | Usually requires sorted data or monotonic constraint |
| Sliding Window | O(n) | O(1) ~ O(k) | Hash-based windows may need O(k) map |
| Binary Search | O(log n) | O(1) | Works on monotonic predicates |
| DFS/BFS | O(V+E) | O(V) | V: vertices, E: edges |
| DP | O(state) | O(state) | Consider state compression when transitions are local |

### Quick visual intuition

Think of each pattern like how much your "bucket" travels:

- O(1): same-size basket every step.
- O(n): one pass over all items once.
- O(log n): jump in larger chunks, like searching a sorted shelf.
- O(V+E): visit every node and edge in a graph map.
