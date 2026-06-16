"""How to reverse a linked list in groups of k"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().reverseKGroup(*args, **kwargs)


class _Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        a = b = head
        for i in range(k):
            if not b:
                return head
            b = b.next
        newHead = self.reverse(a, b)
        a.next = self.reverseKGroup(b, k)
        """
        """
        return newHead
    """  [a, b)  """
    def reverse(self, a: ListNode, b: ListNode) -> ListNode:
        """
        """
        pre, cur, nxt = None, a, a
        while cur != b:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre
