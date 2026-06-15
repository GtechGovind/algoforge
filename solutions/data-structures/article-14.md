# Summary of fancy reversal methods for singly linked lists

## Core idea
# Summary of fancy reversal methods for singly linked lists
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- > Compared with the iterative solution, the time complexity of the recursive solution is O(N), but the space complexity of the iterative solution is O(1), while the recursive solution requires a stack, and the space complexity is O(N).

## Implementation

### Python

```python
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        last = self.reverseList(head.next)
        """
        <extend up -200>
        ![](../pictures
        """
        head.next.next = head
        """
        <extend up -200>
        ![](../pictures
        """
        head.next = None
        """
        <extend up -200>
        ![](../pictures
        """
        return last
```

### Java

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        ![](../pictures
        head.next.next = head;
        ![](../pictures
        head.next = null;
        ![](../pictures
        return last;
    }
}
```

### JavaScript

```javascript
var reverseList = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    var last = reverseList(head.next);
    ![](../pictures
    head.next.next = head;
    ![](../pictures
    head.next = null;
    ![](../pictures
    return last;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
