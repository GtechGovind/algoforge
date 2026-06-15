# Dynamic programming design: longest increasing subsequence

## Core idea
#Dynamic programming design: longest increasing subsequence
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The Longest Increasing Subsequence (LIS) is a very classic algorithm problem. It is easier to think of the dynamic programming solution, with a time complexity of O(N^2). We use this problem to explain how to find the state transition equation and how to write the dynamic programming solution from the shallower to the deeper. What is more difficult to think of is the use of binary search, the time complexity is O(NlogN), we use a simple card game to help understand this ingenious solution.
- At this point, this problem has been solved, with time complexity $O(N^2)$. To summarize how to find the state transition relationship of dynamic programming:
- The time complexity of this solution is $O(NlogN)$, which can be difficult to discover directly. If needed, review the DP transition idea first; once the intuition is clear, this binary-search version becomes much easier to remember.
- Due to the addition of test cases, the binary search version of the `lengthOfLIS` function must be used here to pass all test cases. In this case, the time complexity of the algorithm is $O(NlogN)$, because sorting and calculating LIS each require $O(NlogN)$ time, and together they are still $O(NlogN)$; the space complexity is $O(N)$, because the function to calculate LIS requires a `top` array.

## Implementation

### Python

```python
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
```

### Java

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        ![](../pictures
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

### JavaScript

```javascript
var lengthOfLIS = function(nums) {
    let dp = new Array(nums.length).fill(1);
    ![](../pictures
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
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
