"""Binary Search Tree Center Method (Features)"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().bstToGst(*args, **kwargs)


class _Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        sum = 0
        def traverse(root: TreeNode) -> None:
            nonlocal sum
            if not root:
                return
            traverse(root.right)
            sum += root.val
            root.val = sum
            traverse(root.left)
        traverse(root)
        return root
