"""Optimal substructure principle and dp array traversal direction"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().findPaths(*args, **kwargs)


class _Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        memo = [[[-1 for _ in range(maxMove + 1)] for _ in range(n)] for _ in range(m)]
        def dp(maxMove: int, i: int, j: int) -> int:
            if i < 0 or j < 0 or i >= m or j >= n:
                return 1
            if memo[i][j][maxMove] != -1:
                return memo[i][j][maxMove]
            if maxMove == 0:
                return 0
            res = 0
            res += dp(maxMove - 1, i, j + 1)
            res += dp(maxMove - 1, i + 1, j)
            res += dp(maxMove - 1, i - 1, j)
            res += dp(maxMove - 1, i, j - 1)
            memo[i][j][maxMove] = res % 1000000007
            return memo[i][j][maxMove]
        for plane in memo:
            for row in plane:
                for k in range(maxMove + 1):
                    row[k] = -1
        return dp(maxMove, startRow, startColumn)
