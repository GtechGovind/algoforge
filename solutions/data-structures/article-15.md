# Queue implementation stack and stack implementation queue

## Core idea
# Queue implementation stack and stack implementation queue
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- It is worth mentioning that what is the time complexity of these operations?
- What is a bit interesting is that the `peek` operation may trigger the `while` loop when calling it, in which case the time complexity is O(N), but in most cases the `while` loop will not be triggered, and the time complexity is O(1). Since the `pop` operation calls `peek`, its time complexity is the same as `peek`.
- In this case, it can be said that their **worst time complexity** is O(N), because it contains a `while` loop and **may** need to move elements from `s1` to `s2`.
- But their **amortized time complexity** is O(1). This should be understood like this: an element can only be moved once at most. That is to say, the average time complexity of the `peek` operation to each element is O(1).

## Implementation

### Python

```python
from queue import Queue
class MyStack:
    def __init__(self):
        self.q = Queue()
        self.top_elem = 0
    def push(self, x: int) -> None:
        """
        """
        self.q.put(x)
        self.top_elem = x
    def pop(self) -> int:
        """
        """
        size = self.q.qsize()
        while size > 2:
            self.q.put(self.q.get())
            size -= 1
        self.top_elem = self.q.queue[0]
        self.q.put(self.q.get())
        return self.q.get()
    def top(self) -> int:
        """
        """
        return self.top_elem
    def empty(self) -> bool:
        """
        """
        return self.q.empty()
```

### Java

```java
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;
    public void push(int x) {
        q.offer(x);
        top_elem = x;
    }
    public int top() {
        return top_elem;
    }
    public int pop() {
        int size = q.size();
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        top_elem = q.peek();
        q.offer(q.poll());
        return q.poll();
    }
    public boolean empty() {
        return q.isEmpty();
    }
}
```

### JavaScript

```javascript
var MyStack = function() {
    this.q = [];
    this.top_elem = 0;
};
MyStack.prototype.push = function(x) {
    this.q.push(x);
    this.top_elem = x;
};
MyStack.prototype.top = function() {
    return this.top_elem;
};
MyStack.prototype.pop = function() {
    var size = this.q.length;
    while (size > 2) {
        this.q.push(this.q.shift());
        size--;
    }
    this.top_elem = this.q[0];
    this.q.push(this.q.shift());
    return this.q.shift();
};
MyStack.prototype.empty = function() {
    return this.q.length === 0;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
