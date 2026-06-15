# Binary Tree Mental Method (Construction)

## Core idea
# Binary Tree Mental Method (Construction)
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

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
```

### Java

```java
class Solution {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }
        preorder[preStart..preEnd]
        inorder[inStart..inEnd]
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        ![](../pictures/2/4.jpeg)
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
```

### JavaScript

```javascript
var buildTree = function(preorder, inorder) {
    var valToIndex = new Map();
    for (var i = 0; i < inorder.length; i++) {
        valToIndex.set(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
};
    preorder[preStart..preEnd]
    inorder[inStart..inEnd]
var build = function(preorder, preStart, preEnd,
               inorder, inStart, inEnd) {
    if (preStart > preEnd) {
        return null;
    }
    var rootVal = preorder[preStart];
    var index = valToIndex.get(rootVal);
    var leftSize = index - inStart;
    var root = new TreeNode(rootVal);
    root.left = build(preorder, preStart + 1, preStart + leftSize,
            inorder, inStart, index - 1);
    root.right = build(preorder, preStart + leftSize + 1, preEnd,
            inorder, index + 1, inEnd);
    return root;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
