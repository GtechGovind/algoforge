# Basics of graph theory algorithms

## Core idea
#Basics of graph theory algorithms
![](https://labuladong.online/algo/images/souyisou1.png)

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Time: O(?)
- Space: O(?)

## Implementation

### Python

```python
from typing import List
class Solution:
    def __init__(self):
        self.res = []
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        path = []
        self.traverse(graph, 0, path)
        return self.res
    """  """
    def traverse(self, graph: List[List[int]], s: int, path: List[int]) -> None:
        path.append(s)
        n = len(graph)
        if s == n - 1:
            self.res.append(path[:])
            path.pop()
            return
        for v in graph[s]:
            self.traverse(graph, v, path)
        path.pop()
```

### Java

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);
        int n = graph.length;
        if (s == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        path.removeLast();
    }
}
```

### JavaScript

```javascript
var allPathsSourceTarget = function(graph) {
    var res = [];
    var traverse = function(graph, s, path) {
        path.push(s);
        var n = graph.length;
        if (s === n - 1) {
            res.push(path.slice());
            path.pop();
            return;
        }
        for (var i = 0; i < graph[s].length; i++) {
            traverse(graph, graph[s][i], path);
        }
        path.pop();
    };
    var path = [];
    traverse(graph, 0, path);
    return res;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
