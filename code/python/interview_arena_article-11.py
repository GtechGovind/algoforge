"""Arrange candidates’ seats.

Use a priority rule: always sit the person in the largest gap first.
"""

from __future__ import annotations

import heapq
from typing import Any, List, Tuple


def solve(*args: Any, **kwargs: Any) -> Any:
    """Build and return an `ExamRoom` object for practice."""
    return ExamRoom(*args, **kwargs)


class ExamRoom:
    """Simple version of the exam room seating simulator."""

    def __init__(self, N: int):
        self.N = N
        self.start_map = {}
        self.end_map = {}
        self.pq: List[Tuple[int, int, int]] = []
        self._add_interval([-1, N])

    def seat(self) -> int:
        if not self.pq:
            self._add_interval([-1, self.N])

        _, x, y = heapq.heappop(self.pq)
        if x == -1:
            seat = 0
        elif y == self.N:
            seat = self.N - 1
        else:
            seat = (y - x) // 2 + x

        left = [x, seat]
        right = [seat, y]
        self._remove_interval(left)
        self._remove_interval(right)
        self._add_interval(left)
        self._add_interval(right)
        self.start_map[seat] = left
        self.end_map[seat] = right
        return seat

    def leave(self, p: int) -> None:
        left = self.start_map[p]
        right = self.end_map[p]
        del self.start_map[p]
        del self.end_map[p]

        self._remove_interval(left)
        self._remove_interval(right)

        merged = [left[0], right[1]]
        self._add_interval(merged)

    def _add_interval(self, interval: List[int]) -> None:
        self.pq.append(self._priority(interval))
        self.start_map[interval[0]] = interval
        self.end_map[interval[1]] = interval
        heapq.heapify(self.pq)

    def _remove_interval(self, interval: List[int]) -> None:
        key = self._priority(interval)
        self.pq = [item for item in self.pq if item != key]
        if self.start_map.get(interval[0]) == interval:
            self.start_map.pop(interval[0], None)
        if self.end_map.get(interval[1]) == interval:
            self.end_map.pop(interval[1], None)
        heapq.heapify(self.pq)

    def _priority(self, interval: List[int]) -> Tuple[int, int, int]:
        x, y = interval
        return (-self.distance(interval), -x, -y)

    def distance(self, interval: List[int]) -> int:
        x, y = interval
        if x == -1:
            return y
        if y == self.N:
            return self.N - 1 - x
        return (y - x) // 2
