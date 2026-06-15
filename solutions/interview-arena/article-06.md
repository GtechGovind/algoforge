# How to judge palindrome linked list

## Core idea
#How to judge palindrome linked list
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Of course, whether you create a reverse linked list or use post-order traversal, the time and space complexity of the algorithm are O(N). Now let’s think about it, can we solve this problem without using extra space?
- The overall time complexity of the algorithm is O(N) and the space complexity is O(1), which is already optimal.
- Specific to the problem of judging palindrome linked lists, due to the particularity of palindromes, it is not necessary to completely reverse the linked list, but only to reverse part of the linked list, reducing the space complexity to O(1).

## Implementation

### Python

```python
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        if fast:
            slow = slow.next
        left = head
        right = self.reverse(slow)
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True
    def reverse(self, head: ListNode) -> ListNode:
        pre, cur = None, head
        while cur:
            next_node = cur.next
            cur.next = pre
            pre = cur
            cur = next_node
        return pre
```

### Java

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```

### JavaScript

```javascript
var isPalindrome = function(head) {
  let [slow, fast] = [head, head];
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }
  if (fast !== null)
    slow = slow.next;
  let left = head;
  let right = reverse(slow);
  while (right !== null) {
    if (left.val !== right.val)
      return false;
    left = left.next;
    right = right.next;
  }
  return true;
};
function reverse(head) {
  let [pre, cur] = [null, head];
  while (cur !== null) {
    let next = cur.next;
    cur.next = pre;
    pre = cur;
    cur = next;
  }
  return pre;
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
