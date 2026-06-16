"""Thinking framework when actually using binary search"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().shipWithinDays(*args, **kwargs)


class _Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left = max(weights)
        right = sum(weights)
        while left < right:
            mid = (left + right)
            if self.f(weights, mid) <= days:
                right = mid
            else:
                left = mid + 1
        return left
    def f(self, weights, x):
        days = 0
        i = 0
        while i < len(weights):
            cap = x
            while i < len(weights):
                if cap < weights[i]:
                    break
                else:
                    cap -= weights[i]
                    i += 1
            days += 1
        return days
