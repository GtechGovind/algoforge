"""Shaobing sorting algorithm"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    def __init__(self):
        self.res = []
    def pancakeSort(self, cakes: List[int]) -> List[int]:
        self.sort(cakes, len(cakes))
        return self.res
    def sort(self, cakes: List[int], n: int) -> None:
        if n == 1:
            return
        maxCake = 0
        maxCakeIndex = 0
        for i in range(n):
            if cakes[i] > maxCake:
                maxCakeIndex = i
                maxCake = cakes[i]
        self.reverse(cakes, 0, maxCakeIndex)
        self.res.append(maxCakeIndex + 1)
        self.reverse(cakes, 0, n - 1)
        self.res.append(n)
        self.sort(cakes, n - 1)
    def reverse(self, arr: List[int], i: int, j: int) -> None:
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
