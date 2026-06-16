"""Dynamic programming problem-solving routine framework"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    def __init__(self):
        self.memo = []
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.memo = [-666] * (amount + 1)
        return self.dp(coins, amount)
    def dp(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        if amount < 0:
            return -1
        if self.memo[amount] != -666:
            return self.memo[amount]
        res = float("inf")
        for coin in coins:
            sub_problem = self.dp(coins, amount - coin)
            if sub_problem == -1:
                continue
            res = min(res, sub_problem + 1)
        self.memo[amount] = -1 if res == float("inf") else res
        return self.memo[amount]
