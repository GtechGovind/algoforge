"""Interval scheduling problem of greedy algorithm"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().eraseOverlapIntervals(*args, **kwargs)


class _Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        return n - self.intervalSchedule(intervals)
    def intervalSchedule(self, intvs: List[List[int]]) -> int:
        if len(intvs) == 0:
            return 0
        intvs = sorted(intvs, key=lambda x:x[1])
        count = 1
        x_end = intvs[0][1]
        for interval in intvs:
            start = interval[0]
            if start >= x_end:
                count += 1
                x_end = interval[1]
        return count
