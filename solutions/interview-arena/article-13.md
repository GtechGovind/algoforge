# How to efficiently solve the problem of rainwater collection

## Core idea
# How to efficiently solve the problem of rainwater collection
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```This solution should be very straightforward and crude, with time complexity O(N^2) and space complexity O(1). But it is obvious that this way of calculating `r_max` and `l_max` is very clumsy. It needs to be traversed with a for loop every time. Can we optimize this process?
- Doesn’t the previous brute force solution have to calculate `r_max` and `l_max` at every position `i`? We directly calculate the results in advance, don't be stupid and iterate every time, won't the time complexity be reduced?
- This optimization is actually similar to the brute force solution. It avoids repeated calculations and reduces the time complexity to O(N), which is already optimal, but the space complexity is O(N). Let's look at a more subtle solution that can reduce the space complexity to O(1).
- > This solution is an extension of your thinking, just take a look at it, don’t be too obsessed with the optimal solution. Because for most people, in a real interview/written test, they can use unpretentious methods to show off their tricks and just write the above solution. Although it has a little more space complexity, it can still be passed by general question judging platforms.

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
