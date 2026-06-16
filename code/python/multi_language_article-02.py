"""solution_code"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().isAdditiveNumber(*args, **kwargs)


class _Solution:
    def isAdditiveNumber(self, num):
        n = len(num)
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                first = num[0 : i]
                second = num[i : j]
                if self.isValid(num, first, second):
                    return True
        return False
    def isValid(self, num, first, second):
        if (first.startswith("0") and len(first) > 1) or (second.startswith("0") and len(second) > 1):
            return False
        sumStr = self.strAdd(first, second)
        next = num[len(first) + len(second):]
        if not next.startswith(sumStr):
            return False
        if next == sumStr:
            return True
        return self.isValid(num[len(first):], second, sumStr)
    def strAdd(self, a, b):
