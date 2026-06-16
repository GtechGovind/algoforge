"""BFS Algorithm Problem Solving Routine Framework"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().openLock(*args, **kwargs)


class _Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        visited = set()
        q = collections.deque()
        step = 0
        q.append("0000")
        visited.add("0000")
        while q:
            sz = len(q)
            for i in range(sz):
                cur = q.popleft()
                if cur in deads:
                    continue
                if cur == target:
                    return step
                for j in range(4):
                    up = plusOne(cur,j)
                    if up not in visited:
                        q.append(up)
                        visited.add(up)
                    down = minusOne(cur,j)
                    if down not in visited:
                        q.append(down)
                        visited.add(down)
            step += 1
        return -1
    def plusOne(s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '9':
            ch[j] = '0'
        else:
            ch[j] = chr(ord(ch[j])+1)
        return "".join(ch)
    def minusOne(s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '0':
            ch[j] = '9'
        else:
            ch[j] = chr(ord(ch[j])-1)
        return "".join(ch)
