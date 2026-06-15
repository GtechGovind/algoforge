# How to reverse a linked list in groups of k

## Core idea
# How to reverse a linked list in groups of k
![](https://labuladong.online/algo/images/souyisou1.png)

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
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        a = b = head
        for i in range(k):
            if not b:
                return head
            b = b.next
        newHead = self.reverse(a, b)
        a.next = self.reverseKGroup(b, k)
        """
        <extend up -90>
        ![](../pictures/kgroup/6.jpg)
        """
        return newHead
    """  [a, b)  """
    def reverse(self, a: ListNode, b: ListNode) -> ListNode:
        """
        <extend up -300>
        ![](../pictures/kgroup/8.gif)
        """
        pre, cur, nxt = None, a, a
        while cur != b:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre
```

### Java

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        ![](../pictures/kgroup/6.jpg)
        return newHead;
    }
    ListNode reverse(ListNode a, ListNode b) {
        ![](../pictures/kgroup/8.gif)
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
```

### JavaScript

```javascript
var reverseKGroup = function(head, k) {
    if (!head) return null;
    let a = head, b = head;
    for (let i = 0; i < k; i++) {
        if (!b) return head;
        b = b.next;
    }
    let newHead = reverse(a, b);
    a.next = reverseKGroup(b, k);
    ![](../pictures/kgroup/6.jpg)
    return newHead;
};
var reverse = function(a, b) {
    ![](../pictures/kgroup/8.gif)
    let pre = null, cur = a, nxt = a;
    while (cur !== b) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    return pre;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
