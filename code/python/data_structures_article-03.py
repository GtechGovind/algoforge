"""Dijkstra algorithm template and application"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().maxProbability(*args, **kwargs)


class _Solution:
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
