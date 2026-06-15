# How to efficiently solve the problem of rainwater collection

## Core idea
# How to efficiently solve the problem of rainwater collection
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```This solution should be very straightforward and crude, with time complexity O(N^2) and space complexity O(1). But it is obvious that this way of calculating `r_max` and `l_max` is very clumsy. It needs to be traversed with a for loop every time. Can we optimize this process?
- Doesn’t the previous brute force solution have to calculate `r_max` and `l_max` at every position `i`? If we precompute them up front, we can avoid repeating work and reduce the time complexity.
- This optimization is actually similar to the brute force solution. It avoids repeated calculations and reduces the time complexity to O(N), which is already optimal, but the space complexity is O(N). Let's look at a more subtle solution that can reduce the space complexity to O(1).
- > This solution is an extension of your thinking, worth reviewing once. In interviews, a correct and clear solution is usually more valuable than a highly optimized one. This version is slightly heavier in space, but it is still valid and interview-friendly.

## Implementation

### Python

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height)-1
        res = 0
        while left < right:
            cur_area = min(height[left], height[right]) * (right - left)
            res = max(res, cur_area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return res
```

### Java

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
```

### JavaScript

```javascript
var maxArea = function(height) {
    let left = 0, right = height.length - 1;
    let res = 0;
    while (left < right) {
        const cur_area = Math.min(height[left], height[right]) * (right - left);
        res = Math.max(res, cur_area);
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return res;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
