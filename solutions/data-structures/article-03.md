# Dijkstra algorithm template and application

## Core idea
# Dijkstra algorithm template and application
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- What is the time complexity of Dijkstra's algorithm? If you check it online, you may be told that it is $O(ElogV)$, where `E` represents the number of edges in the graph, and `V` represents the number of nodes in the graph.
- Because under ideal circumstances, a maximum of `V` nodes can be installed in the priority queue, and the number of operations on the priority queue is proportional to `E`, so the overall time complexity is $O(ElogV)$.
- However, this is an ideal situation. There are many versions of code implementations of Dijkstra's algorithm. Different programming languages ​​or different data structure APIs will cause some changes in the time complexity of the algorithm.
- Therefore, the complexity of the Dijkstra algorithm implemented in this article is not $O(ElogV)$ under ideal circumstances, but $O(ElogE)$, which may be slightly larger, because the number of edges in the graph is generally greater than the number of nodes.

## Implementation

### Python

```python
import heapq
from typing import List
class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        graph = [[] for _ in range(n)]
        for i in range(len(edges)):
            from_, to = edges[i][0], edges[i][1]
            weight = succProb[i]
            graph[from_].append((to, weight))
            graph[to].append((from_, weight))
        return self.dijkstra(start, end, graph)
    class State:
        def __init__(self, id_, distFromStart):
            self.id = id_
            self.distFromStart = distFromStart
        def __lt__(self, other):
            return self.distFromStart > other.distFromStart
    def dijkstra(self, start, end, graph):
        V = len(graph)
        distTo = [-1] * V
        distTo[start] = 1
        pq = []
        heapq.heappush(pq, self.State(start, 1))
        while pq:
            curState = heapq.heappop(pq)
            curNodeID = curState.id
            curDistFromStart = curState.distFromStart
            if curNodeID == end:
                return curDistFromStart
            if curDistFromStart < distTo[curNodeID]:
                continue
            for neighbor in graph[curNodeID]:
                nextNodeID = neighbor[0]
                distToNextNode = distTo[curNodeID] * neighbor[1]
                if distTo[nextNodeID] < distToNextNode:
                    distTo[nextNodeID] = distToNextNode
                    heapq.heappush(pq, self.State(nextNodeID, distToNextNode))
        return 0.0
```

### Java

```java
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{(double)to, weight});
            graph[to].add(new double[]{(double)from, weight});
        }
        return dijkstra(start, end, graph);
    }
    class State {
        int id;
        double distFromStart;
        State(int id, double distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
    double dijkstra(int start, int end, List<double[]>[] graph) {
        int V = graph.length;
        double[] distTo = new double[V];
        Arrays.fill(distTo, -1);
        distTo[start] = 1;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.distFromStart, a.distFromStart);
        });
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            double curDistFromStart = curState.distFromStart;
            if (curNodeID == end) {
                return curDistFromStart;
            }
            if (curDistFromStart < distTo[curNodeID]) {
                continue;
            }
            for (double[] neighbor : graph[curNodeID]) {
                int nextNodeID = (int)neighbor[0];
                double distToNextNode = distTo[curNodeID] * neighbor[1];
                if (distTo[nextNodeID] < distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return 0.0;
    }
}
```

### JavaScript

```javascript
var maxProbability = function(n, edges, succProb, start, end) {
    const graph = [];
    for (let i = 0; i < n; i++) {
        graph[i] = [];
    }
    for (let i = 0; i < edges.length; i++) {
        const from = edges[i][0];
        const to = edges[i][1];
        const weight = succProb[i];
        graph[from].push([to, weight]);
        graph[to].push([from, weight]);
    }
    return dijkstra(start, end, graph);
};
class State {
    constructor(id, distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
function dijkstra(start, end, graph) {
    const V = graph.length;
    const distTo = new Array(V).fill(-1);
    distTo[start] = 1;
    const pq = new PriorityQueue({
        compare: (a, b) => {
            return b.distFromStart - a.distFromStart;
        }
    });
    pq.enqueue(new State(start, 1));
    while (!pq.isEmpty()) {
        const curState = pq.dequeue();
        const curNodeID = curState.id;
        const curDistFromStart = curState.distFromStart;
        if (curNodeID === end) {
            return curDistFromStart;
        }
        if (curDistFromStart < distTo[curNodeID]) {
            continue;
        }
        for (const neighbor of graph[curNodeID]) {
            const nextNodeID = neighbor[0];
            const distToNextNode = distTo[curNodeID] * neighbor[1];
            if (distTo[nextNodeID] < distToNextNode) {
                distTo[nextNodeID] = distToNextNode;
                pq.enqueue(new State(nextNodeID, distToNextNode));
            }
        }
    }
    return 0.0;
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
