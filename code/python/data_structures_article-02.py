"""Binary Search Tree Heart Method (Basic Operations)"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().deleteNode(*args, **kwargs)


class _Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None
        if root.val == key:
            if not root.left:
                return root.right
            if not root.right:
                return root.left
            min_node = self.getMin(root.right)
            root.right = self.deleteNode(root.right, min_node.val)
            min_node.left = root.left
            min_node.right = root.right
            root = min_node
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        return root
    def getMin(self, node: TreeNode) -> TreeNode:
        while node.left:
            node = node.left
        return node
