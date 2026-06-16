"""Ring detection and topological sorting algorithm"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().canFinish(*args, **kwargs)


class _Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        onPath = [False] * numCourses
        visited = [False] * numCourses
        hasCycle = [False]
        graph = self.buildGraph(numCourses, prerequisites)
        def traverse(s):
            if onPath[s]:
                hasCycle[0] = True
                """
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
