"""Hand-made LRU Cache.

A tiny memory game: keep recently used keys close to the front.
"""

from __future__ import annotations

from collections import OrderedDict
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Build and return a ready-to-use `LRUCache` object."""
    return LRUCache(*args, **kwargs)


class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key)
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            self.cache.move_to_end(key)
            return
        if len(self.cache) >= self.cap:
            self.cache.popitem(last=False)
        self.cache[key] = value
