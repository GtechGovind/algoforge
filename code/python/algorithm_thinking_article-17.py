"""Backtracking algorithm practice: set partitioning"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().canPartitionKSubsets(*args, **kwargs)


class _Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if k > len(nums):
            return False
        _sum = sum(nums)
        if _sum % k != 0:
            return False
        used = 0
        target = _sum
        return self.backtrack(k, 0, nums, 0, used, target, {})
    def backtrack(self, k: int, bucket: int, nums: List[int], start: int, used: int, target: int, memo: Dict[int, bool]) -> bool:
        if k == 0:
            return True
        if bucket == target:
            if used in memo:
                return memo[used]
            res = self.backtrack(k - 1, 0, nums, 0, used, target, memo)
            memo[used] = res
            return res
        for i in range(start, len(nums)):
            if used >> i & 1 == 1:
                continue
            if nums[i] + bucket > target:
                continue
            used |= 1 << i
            bucket += nums[i]
            if self.backtrack(k, bucket, nums, i + 1, used, target, memo):
                return True
            used ^= 1 << i
            bucket -= nums[i]
        return False
