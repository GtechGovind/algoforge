# Monotone queue structure solves the sliding window problem

## Core idea
# Monotone queue structure solves the sliding window problem
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- But in the example of judging the maximum value in a window mentioned at the beginning of this article, you cannot update the maximum value of the window based solely on the element that is moved out of the window, unless you re-traverse all the elements, but in this case the time complexity will increase, which is what we don't want to see.
- Of course, the implementation methods of the monotonic queue APIs are certainly different from those of ordinary Queues, but we don’t care about it for the time being, and believe that the time complexity of these operations is O(1). Let’s first lay out the solution framework for this “sliding window” problem:
- Regarding the time complexity of the monotonic queue API, readers may have doubts: the `push` operation contains a while loop, and the worst-case time complexity should be $O(N)$. With the addition of a for loop, the time complexity of this algorithm should be $O(N^2)$, right?
- The amortization analysis mentioned in [Algorithm Space-Time Complexity Analysis Guide](https://labuladong.online/algo/essential-technique/complexity-analysis/) is used here:

## Implementation

### Python

```python
class Solution:
    class MonotonicQueue:
        def __init__(self):
            self.q = []
        def push(self, n):
            while self.q and self.q[-1] < n:
                self.q.pop()
            self.q.append(n)
        def max(self):
            return self.q[0]
        def pop(self, n):
            if n == self.q[0]:
                self.q.pop(0)
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = self.MonotonicQueue()
        res = []
        for i in range(len(nums)):
            if i < k - 1:
                window.push(nums[i])
            else:
                window.push(nums[i])
                res.append(window.max())
                window.pop(nums[i - k + 1])
        return res
```

### Java

```java
class Solution {
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                ![](../pictures
                q.pollLast();
            }
            q.addLast(n);
        }
        public int max() {
            return q.getFirst();
        }
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                ![](../pictures
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
```

### JavaScript

```javascript
var maxSlidingWindow = function(nums, k) {
    class MonotonicQueue {
        constructor() {
            this.q = []
        }
        push(n) {
            while (this.q.length !== 0 && this.q[this.q.length - 1] < n) {
                ![](../pictures
                this.q.pop()
            }
            this.q.push(n)
        }
        max() {
            return this.q[0]
        }
        pop(n) {
            if (this.q[0] === n) {
                this.q.shift()
            }
        }
    }
    const window = new MonotonicQueue()
    const res = []
    for (let i = 0; i < nums.length; i++) {
        if (i < k - 1) {
            window.push(nums[i])
        } else {
            ![](../pictures
            window.push(nums[i])
            res.push(window.max())
            window.pop(nums[i - k + 1])
        }
    }
    return res
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
