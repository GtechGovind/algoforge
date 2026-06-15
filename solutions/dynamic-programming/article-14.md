# Classic dynamic programming: edit distance

## Core idea
# Classic dynamic programming: edit distance
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- There is another detail. Since each `dp[i][j]` is only related to the three states near it, the space complexity can be compressed into $O(min(M, N))$ (M, N are the lengths of the two strings). It's not difficult, but the interpretability is greatly reduced. Readers can try to optimize it themselves.

## Implementation

### Python

```python
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        dp = [[0] * (n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            dp[i][0] = i
        for j in range(1, n+1):
            dp[0][j] = j
        for i in range(1, m+1):
            for j in range(1, n+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(
                        dp[i-1][j] + 1,
                        dp[i][j-1] + 1,
                        dp[i-1][j-1] + 1
                    )
        return dp[m][n]
```

### Java

```java
class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,
                        ![](../pictures/editDistance/delete.gif)
                        dp[i][j - 1] + 1,
                        ![](../pictures/editDistance/insert.gif)
                        dp[i - 1][j - 1] + 1
                        ![](../pictures/editDistance/replace.gif)
                    );
        return dp[m][n];
    }
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
```

### JavaScript

```javascript
var minDistance = function(s1, s2) {
    let m = s1.length, n = s2.length;
    let dp = new Array(m + 1).fill().map(() => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++)
        dp[i][0] = i;
    for (let j = 1; j <= n; j++)
        dp[0][j] = j;
    for (let i = 1; i <= m; i++)
        for (let j = 1; j <= n; j++)
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else
                dp[i][j] = Math.min(
                    dp[i - 1][j] + 1,
                    ![](../pictures/editDistance/delete.gif)
                    dp[i][j - 1] + 1,
                    ![](../pictures/editDistance/insert.gif)
                    dp[i - 1][j - 1] + 1
                    ![](../pictures/editDistance/replace.gif)
                );
    return dp[m][n];
}
function min(a, b, c) {
    return Math.min(a, Math.min(b, c));
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
