# Ring detection and topological sorting algorithm

## Core idea
# Ring detection and topological sorting algorithm
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

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
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        onPath = [False] * numCourses
        visited = [False] * numCourses
        hasCycle = [False]
        graph = self.buildGraph(numCourses, prerequisites)
        def traverse(s):
            if onPath[s]:
                hasCycle[0] = True
                """
                <extend up -150>
                ![](../pictures
                """
            if visited[s] or hasCycle[0]:
                return
            visited[s] = True
            onPath[s] = True
            for t in graph[s]:
                traverse(t)
            onPath[s] = False
        for i in range(numCourses):
            traverse(i)
        return not hasCycle[0]
    def buildGraph(self, numCourses, prerequisites):
        graph = [[] for _ in range(numCourses)]
        for from_, to in prerequisites:
            graph[from_].append(to)
        return graph
```

### Java

```java
class Solution {
    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
            ![](../pictures
        }
        if (visited[s] || hasCycle) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
```

### JavaScript

```javascript
var canFinish = function(numCourses, prerequisites) {
    const onPath = new Array(numCourses).fill(false);
    const visited = new Array(numCourses).fill(false);
    let hasCycle = false;
    const graph = buildGraph(numCourses, prerequisites);
    for (let i = 0; i < numCourses; i++) {
        traverse(graph, i);
    }
    return !hasCycle;
    function traverse(graph, s) {
        if (onPath[s]) {
            hasCycle = true;
            ![](../pictures
            return;
        }
        if (visited[s] || hasCycle) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (let t of graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }
    function buildGraph(numCourses, prerequisites) {
        const graph = new Array(numCourses).map(() => []);
        for (let edge of prerequisites) {
            const from = edge[1];
            const to = edge[0];
            graph[from].push(to);
        }
        return graph;
    }
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
