"""Queue implementation stack and stack implementation queue.

We keep one real queue of numbers and use one helper move to make `pop()` feel like stack behaviour.
"""

from __future__ import annotations

from queue import Queue
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Build and return a `MyStack` toy object for hands-on practice."""
    return MyStack()


class MyStack:
    def __init__(self):
        self.q = Queue()
        self.top_elem = 0

    def push(self, x: int) -> None:
        self.q.put(x)
        self.top_elem = x

    def pop(self) -> int:
        size = self.q.qsize()
        while size > 2:
            self.q.put(self.q.get())
            size -= 1
        self.top_elem = self.q.queue[0]
        self.q.put(self.q.get())
        return self.q.get()

    def top(self) -> int:
        return self.top_elem

    def empty(self) -> bool:
        return self.q.empty()
