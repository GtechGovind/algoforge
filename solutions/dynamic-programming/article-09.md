# One method to eliminate LeetCode stock trading problem

## Core idea
# One method to eliminate LeetCode stock trading problem
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```The first question is solved, but it is very troublesome to deal with the base case in this way, and pay attention to the state transition equation. The new state is only related to one adjacent state, so you can use the previous article [Dynamic Programming’s Dimensionality Reduction: Space Compression Technique](https://labuladong.online/algo/dynamic-programming/space-optimization/). You don’t need to use the entire `dp` array. It is enough to store the adjacent state in one variable, which can reduce the space complexity to O(1):
- // Space complexity optimized version
- // Space complexity optimized version
- // Space complexity optimized version

## Implementation

### Python

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]
        for i in range(n):
            if i - 1 == -1:
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[n - 1][0]
```

### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

### JavaScript

```javascript
var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).map(() => new Array(2));
    for (let i = 0; i < n; i++) {
        if (i - 1 === -1) {
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
