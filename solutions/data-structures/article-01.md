# Binary Search Tree Center Method (Features)

## Core idea
# Binary Search Tree Center Method (Features)
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- If we follow the method we just mentioned and use the property that "BST in-order traversal is the ascending sort result", each time we find the `k'th smallest element, we have to traverse in-order once. The worst time complexity is $O(N)$, where `N` is the number of nodes in BST.
- You must know that the properties of BST are very powerful. For improved self-balancing BST like red-black tree, the complexity of adding, deleting, checking and modifying is $O(logN)$. If you calculate a `k`th small element, the time complexity is actually $O(N)$, which is a bit inefficient.
- Therefore, the best algorithm to calculate the `k`th smallest element must also have logarithmic complexity, but this depends on how much information is recorded by the BST node.
- Let’s think about why the operation of BST is so efficient? Take the search for a certain element as an example. The fundamental reason why BST can find the element in logarithmic time is still in the definition of BST. The left subtree is smaller than the right subtree and larger, so each node can judge whether to search the target value in the left subtree or the right subtree by comparing its own value, thus avoiding the need for full tree traversal and achieving logarithmic level complexity.

## Implementation

### Python

```python
class Solution:
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
```

### Java

```java
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
```

### JavaScript

```javascript
var bstToGst = function(root) {
  let sum = 0;
  const traverse = function(root) {
    if (root == null) {
      return;
    }
    traverse(root.right);
    sum += root.val;
    root.val = sum;
    traverse(root.left);
  }
  traverse(root);
  return root;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
