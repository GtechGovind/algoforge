# Optimal substructure principle and dp array traversal direction

## Core idea
# Optimal substructure principle and dp array traversal direction
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Time: O(?)
- Space: O(?)

## Implementation

### Python

```python
class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        memo = [[[-1 for _ in range(maxMove + 1)] for _ in range(n)] for _ in range(m)]
        def dp(maxMove: int, i: int, j: int) -> int:
            if i < 0 or j < 0 or i >= m or j >= n:
                return 1
            if memo[i][j][maxMove] != -1:
                return memo[i][j][maxMove]
            if maxMove == 0:
                return 0
            res = 0
            res += dp(maxMove - 1, i, j + 1)
            res += dp(maxMove - 1, i + 1, j)
            res += dp(maxMove - 1, i - 1, j)
            res += dp(maxMove - 1, i, j - 1)
            memo[i][j][maxMove] = res % 1000000007
            return memo[i][j][maxMove]
        for plane in memo:
            for row in plane:
                for k in range(maxMove + 1):
                    row[k] = -1
        return dp(maxMove, startRow, startColumn)
```

### Java

```java
class Solution {
    int[][][] memo;
    int m, n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        memo = new int[m][n][maxMove + 1];
        for (int[][] plane : memo) {
            for (int[] row : plane) {
                Arrays.fill(row, -1);
            }
        }
        return dp(maxMove, startRow, startColumn);
    }
    int dp(int maxMove, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (memo[i][j][maxMove] != -1) {
            return memo[i][j][maxMove];
        }
        if (maxMove == 0) {
            return 0;
        }
        long res = 0;
        res += dp(maxMove - 1, i, j + 1);
        res += dp(maxMove - 1, i + 1, j);
        res += dp(maxMove - 1, i - 1, j);
        res += dp(maxMove - 1, i, j - 1);
        memo[i][j][maxMove] = (int) (res % 1000000007);
        return memo[i][j][maxMove];
    }
}
```

### JavaScript

```javascript
var findPaths = function(m, n, maxMove, startRow, startColumn) {
    let memo = new Array(m);
    for (let i = 0; i < m; i++) {
        memo[i] = new Array(n);
        for (let j = 0; j < n; j++) {
            memo[i][j] = new Array(maxMove + 1).fill(-1);
        }
    }
    return dp(maxMove, startRow, startColumn);
    function dp(maxMove, i, j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (memo[i][j][maxMove] !== -1) {
            return memo[i][j][maxMove];
        }
        if (maxMove === 0) {
            return 0;
        }
        let res = 0;
        res += dp(maxMove - 1, i, j + 1);
        res += dp(maxMove - 1, i + 1, j);
        res += dp(maxMove - 1, i - 1, j);
        res += dp(maxMove - 1, i, j - 1);
        memo[i][j][maxMove] = res % 1000000007;
        return memo[i][j][maxMove];
    }
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
