# One method to eliminate LeetCode’s robbery problem

## Core idea
# One method to eliminate LeetCode’s robbery problem
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```We also found that the state transition is only related to the two most recent states of `dp[i]`, so it can be further optimized to reduce the space complexity to O(1).
- Analyzing the time complexity, although this recursive structure seems to be a quadtree, in fact due to the optimization of the memo, the recursive function still traverses each node and does not enter the same node multiple times, so the time complexity is still $O(N)$, `N` is the number of nodes in the tree. The space complexity is the size of the memo, which is $O(N)$.
- If you are confused about time/space complexity analysis, you can refer to [Practical Guide to Time and Space Complexity Analysis](https://labuladong.online/algo/essential-technique/complexity-analysis/).
- ```The time complexity is still $O(N)$, and the space complexity is only the space required for the recursive function stack, that is, the height of the tree $O(H)$, and no additional space for the memo is required.

## Implementation

### Python

```python
class Solution:
    def __init__(self):
        self.memo = []
    def rob(self, nums: List[int]) -> int:
        self.memo = [-1] * len(nums)
        return self.dp(nums, 0)
    def dp(self, nums: List[int], start: int) -> int:
        if start >= len(nums):
            return 0
        if self.memo[start] != -1:
            return self.memo[start]
        res = max(self.dp(nums, start + 1),
                  nums[start] + self.dp(nums, start + 2))
        self.memo[start] = res
        return res
```

### Java

```java
class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) return memo[start];
        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;
    }
}
```

### JavaScript

```javascript
var rob = function(nums) {
    let memo = new Array(nums.length).fill(-1);
    return dp(nums, 0, memo);
};
function dp(nums, start, memo) {
    if (start >= nums.length) {
        return 0;
    }
    if (memo[start] != -1) return memo[start];
    let res = Math.max(dp(nums, start + 1, memo),
            nums[start] + dp(nums, start + 2, memo));
    memo[start] = res;
    return res;
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
