# Classic dynamic programming: longest common subsequence

## Core idea
# Classic dynamic programming: longest common subsequence
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Obviously, the complexity of this idea is very high. If you want to enumerate all subsequences, the complexity is exponential, which is definitely not practical.
- In addition, the bottom-up solution can be optimized through the [dynamic programming space compression technique] (https://labuladong.online/algo/dynamic-programming/space-optimization/) that we have talked about before, and the space complexity can be compressed to O(N). Due to space limitations, we will not expand it here.

## Implementation

### Python

```python
class Solution:
    def longestCommonSubsequence(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        return dp[m][n]
```

### Java

```java
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
```

### JavaScript

```javascript
var longestCommonSubsequence = function(s1, s2) {
    const m = s1.length, n = s2.length;
    const dp = new Array(m + 1).fill(0).map(() => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[m][n];
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
