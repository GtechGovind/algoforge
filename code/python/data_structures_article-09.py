"""Monotone queue structure solves the sliding window problem"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    class MonotonicQueue:
        def __init__(self):
            self.q = []
        def push(self, n):
            while self.q and self.q[-1] < n:
                self.q.pop()
            self.q.append(n)
        def max(self):
            return self.q[0]
        def pop(self, n):
            if n == self.q[0]:
                self.q.pop(0)
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = self.MonotonicQueue()
        res = []
        for i in range(len(nums)):
            if i < k - 1:
                window.push(nums[i])
            else:
                window.push(nums[i])
                res.append(window.max())
                window.pop(nums[i - k + 1])
        return res
