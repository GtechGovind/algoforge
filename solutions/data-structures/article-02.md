# Binary Search Tree Heart Method (Basic Operations)

## Core idea
# Binary Search Tree Heart Method (Basic Operations)
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Time: O(?)
- Space: O(?)

## Implementation

### Python

```python
class Solution:
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
```

### Java

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
```

### JavaScript

```javascript
var deleteNode = function(root, key) {
    if (root == null) return null;
    if (root.val == key) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        let minNode = getMin(root.right);
        root.right = deleteNode(root.right, minNode.val);
        minNode.left = root.left;
        minNode.right = root.right;
        root = minNode;
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
};
var getMin = function(node) {
    while (node.left != null) node = node.left;
    return node;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
