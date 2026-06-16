"""Backtracking algorithm instantly kills all permutation/combination/subset problems"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    def __init__(self):
        self.res = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.res
        self.backtrack(candidates, 0, target, 0)
        return self.res
    track = []
    def backtrack(self, candidates, start, target, sum):
        if sum == target:
            self.res.append(self.track[:])
            return
        if sum > target:
            return
        for i in range(start, len(candidates)):
            self.track.append(candidates[i])
            sum += candidates[i]
            self.backtrack(candidates, i, target, sum)
            sum -= candidates[i]
            self.track.pop()
