"""Classic dynamic programming: game problem"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().stoneGame(*args, **kwargs)


class _Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        return True
