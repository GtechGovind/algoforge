"""Fix errors in the labuladong quiz plug-in"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().searchMatrix(*args, **kwargs)


class _Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        while(left <= right):
            mid = left + (right - left)
            if(self.get(matrix, mid) == target):
                return True
            elif self.get(matrix, mid) < target:
                left = mid + 1
            elif self.get(matrix, mid) > target:
                right = mid - 1
        return False
    def get(self, matrix: List[List[int]], index: int) -> int:
        m, n = len(matrix), len(matrix[0])
        i, j = index
        return matrix[i][j]
