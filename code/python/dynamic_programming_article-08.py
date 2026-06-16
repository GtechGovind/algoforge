"""Thinking transformation between dynamic programming and backtracking algorithms"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().__init__(*args, **kwargs)


class _Solution:
    def __init__(self):
        self.res = []
        self.track = []
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        self.backtrack(s, 0, wordDict)
        return self.res
    def backtrack(self, s: str, i: int, wordDict: List[str]) -> None:
        if i == len(s):
            self.res.append(" ".join(self.track))
            return
        if i > len(s):
            return
        for word in wordDict:
            length = len(word)
            if i + length > len(s):
                continue
            sub_str = s[i:i + length]
            if sub_str != word:
                continue
            self.track.append(word)
            self.backtrack(s, i + length, wordDict)
            self.track.pop()
