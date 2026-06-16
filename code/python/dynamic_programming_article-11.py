"""One method to eliminate LeetCode’s robbery problem"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    def __init__(self):
        self.memo = []
    def rob(self, nums: List[int]) -> int:
        self.memo = [-1] * len(nums)
        return self.dp(nums, 0)
    def dp(self, nums: List[int], start: int) -> int:
        if start >= len(nums):
            return 0
        if self.memo[start] != -1:
            return self.memo[start]
        res = max(self.dp(nums, start + 1),
                  nums[start] + self.dp(nums, start + 2))
        self.memo[start] = res
        return res
