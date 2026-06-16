"""Algorithm problems that can be solved with one line of code"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().canWinNim(*args, **kwargs)


class _Solution:
    def canWinNim(self, n: int) -> bool:
        return n % 4 != 0
