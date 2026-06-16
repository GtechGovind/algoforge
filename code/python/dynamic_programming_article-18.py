"""Dynamic programming helped me pass "Magic Tower""""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().calculateMinimumHP(*args, **kwargs)


class _Solution:
    def calculateMinimumHP(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        memo = [[-1 for _ in range(n)] for _ in range(m)]
        return self.dp(grid, 0, 0, memo)
    def dp(self, grid: List[List[int]], i: int, j: int, memo: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        if i == m - 1 and j == n - 1:
            return 1 if grid[i][j] >= 0 else -grid[i][j] + 1
        if i == m or j == n:
            return float('inf')
        if memo[i][j] != -1:
            return memo[i][j]
        res = min(
                self.dp(grid, i, j + 1, memo),
                self.dp(grid, i + 1, j, memo)
        ) - grid[i][j]
        memo[i][j] = 1 if res <= 0 else res
        return memo[i][j]
