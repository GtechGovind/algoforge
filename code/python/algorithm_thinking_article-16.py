"""Fancy traversal techniques for two-dimensional arrays"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().reverseWords(*args, **kwargs)


class _Solution:
    def reverseWords(self, s: str) -> str:
        sb = []
        for c in s:
            if c != ' ':
                sb.append(c)
            elif sb and sb[-1] != ' ':
                sb.append(' ')
        if sb and sb[-1] == ' ':
            sb.pop()
        chars = sb
        def reverse(l, r):
            while l < r:
                chars[l], chars[r] = chars[r], chars[l]
                l += 1
                r -= 1
        n = len(chars)
        reverse(0, n-1)
        start = end = 0
        while end < n:
            if chars[end] == ' ':
                reverse(start, end-1)
                start = end + 1
            end += 1
        reverse(start, n-1)
        return "".join(chars)
