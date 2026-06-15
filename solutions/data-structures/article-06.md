# Binary tree mental method (ideas)

## Core idea
# Binary tree mental method (ideas)
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
```

### Java

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
        ![](../pictures
    }
}
```

### JavaScript

```javascript
var flatten = function(root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    var left = root.left;
    var right = root.right;
    root.left = null;
    root.right = left;
    var p = root;
    while (p.right != null) {
        p = p.right;
    }
    p.right = right;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
