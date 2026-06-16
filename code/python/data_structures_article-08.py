"""Monotone stack algorithm template to solve three example problems"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().nextGreaterElement(*args, **kwargs)


class _Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        greater = self.nextGreater(nums2)
        greaterMap = {}
        for i in range(len(nums2)):
            greaterMap[nums2[i]] = greater[i]
        res = []
        for num in nums1:
            res.append(greaterMap[num])
        return res
    def nextGreater(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * n
        s = []
        for i in range(n - 1, -1, -1):
            while s and s[-1] <= nums[i]:
                s.pop()
            if s:
                res[i] = s[-1]
            s.append(nums[i])
        return res
