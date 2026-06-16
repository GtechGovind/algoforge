"""Summary of fancy reversal methods for singly linked lists"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().reverseList(*args, **kwargs)


class _Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        last = self.reverseList(head.next)
        """
        """
        head.next.next = head
        """
        """
        head.next = None
        """
        """
        return last
