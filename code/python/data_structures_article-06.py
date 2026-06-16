"""Binary tree mental method (ideas)"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().flatten(*args, **kwargs)


class _Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flatten(root.left)
        self.flatten(root.right)
        left = root.left
        right = root.right
        root.left = None
        root.right = left
        p = root
        while p.right:
            p = p.right
        p.right = right
