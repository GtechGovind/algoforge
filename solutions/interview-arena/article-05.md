# Thinking framework when actually using binary search

## Core idea
# Thinking framework when actually using binary search
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Because our binary search has a logarithmic level of complexity, even if `right` is a large value, the efficiency of the algorithm is still very high.

## Implementation

### Python

```python
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left = max(weights)
        right = sum(weights)
        while left < right:
            mid = (left + right)
            if self.f(weights, mid) <= days:
                right = mid
            else:
                left = mid + 1
        return left
    def f(self, weights, x):
        days = 0
        i = 0
        while i < len(weights):
            cap = x
            while i < len(weights):
                if cap < weights[i]:
                    break
                else:
                    cap -= weights[i]
                    i += 1
            days += 1
        return days
```

### Java

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
```

### JavaScript

```javascript
var shipWithinDays = function(weights, days) {
    let left = 0;
    let right = 1;
    for (let w of weights) {
        left = Math.max(left, w);
        right += w;
    }
    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (f(weights, mid) <= days) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
};
function f(weights, x) {
    let days = 0;
    for (let i = 0; i < weights.length; ) {
        let cap = x;
        while (i < weights.length) {
            if (cap < weights[i]) break;
            else cap -= weights[i];
            i++;
        }
        days++;
    }
    return days;
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
