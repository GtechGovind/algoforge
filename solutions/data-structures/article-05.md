# Core program of binary tree series algorithms

## Core idea
# Core program of binary tree series algorithms
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- One reason is that the complexity of this algorithm is difficult to control and relies heavily on language features.
- In Java, regardless of ArrayList or LinkedList, the complexity of the `addAll` method is O(N), so the overall worst-case time complexity will reach O(N^2), unless you implement an `addAll` method with a complexity of O(1) yourself. This is possible if you use a linked list at the bottom, because multiple linked lists can be connected with simple pointer operations.
- This solution is correct, but the running time is very long. The reason is obvious. When `traverse` traverses each node, it also calls the recursive function `maxDepth`, and `maxDepth` needs to traverse all nodes of the subtree, so the worst-case time complexity is O(N^2).
- Now the time complexity is only O(N) of the `maxDepth` function.

## Implementation

### Python

```python
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        self.res = 0
        self.traverse(root, 0)
        return self.res
    def traverse(self, root: TreeNode, depth: int) -> None:
        if not root:
            return
        depth += 1
        self.res = max(self.res, depth)
        self.traverse(root.left, depth)
        self.traverse(root.right, depth)
        depth -= 1
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        return 1 + max(leftMax, rightMax)
```

### Java

```java
class Solution {
    int depth = 0;
    int res = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

### JavaScript

```javascript
function maxDepth(root) {
    let depth = 0;
    let res = 0;
    function traverse(root) {
        if (root === null) {
        return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
    traverse(root);
    return res;
}
function maxDepth2(root) {
    if (root === null) {
        return 0;
    }
    const leftMax = maxDepth2(root.left);
    const rightMax = maxDepth2(root.right);
    return 1 + Math.max(leftMax, rightMax);
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
