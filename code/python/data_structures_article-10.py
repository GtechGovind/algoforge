"""Basics of graph theory algorithms"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
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
