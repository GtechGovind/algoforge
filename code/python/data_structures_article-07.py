"""Binary Tree Mental Method (Construction)"""

from __future__ import annotations
from typing import Any


def solve(*args: Any, **kwargs: Any) -> Any:
    """Run this lesson exercise with positional inputs."""
    return _Solution().buildTree(*args, **kwargs)


class _Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        valToIndex = {}
        for i in range(len(inorder)):
            valToIndex[inorder[i]] = i
        return self.build(preorder, 0, len(preorder) - 1,
                          inorder, 0, len(inorder) - 1, valToIndex)
    def build(self, preorder, preStart, preEnd, inorder, inStart, inEnd, valToIndex):
        if preStart > preEnd:
            return None
        rootVal = preorder[preStart]
        index = valToIndex[rootVal]
        leftSize = index - inStart
        root = TreeNode(rootVal)
        root.left = self.build(preorder, preStart + 1, preStart + leftSize,
                               inorder, inStart, index - 1, valToIndex)
        root.right = self.build(preorder, preStart + leftSize + 1, preEnd,
                                inorder, index + 1, inEnd, valToIndex)
        return root
