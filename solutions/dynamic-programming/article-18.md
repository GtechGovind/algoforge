# Dynamic programming helped me pass "Magic Tower"

## Core idea
# Dynamic programming helped me pass "Magic Tower"
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

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
    def calculateMinimumHP(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        memo = [[-1 for _ in range(n)] for _ in range(m)]
        return self.dp(grid, 0, 0, memo)
    def dp(self, grid: List[List[int]], i: int, j: int, memo: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        if i == m - 1 and j == n - 1:
            return 1 if grid[i][j] >= 0 else -grid[i][j] + 1
        if i == m or j == n:
            return float('inf')
        if memo[i][j] != -1:
            return memo[i][j]
        res = min(
                self.dp(grid, i, j + 1, memo),
                self.dp(grid, i + 1, j, memo)
        ) - grid[i][j]
        memo[i][j] = 1 if res <= 0 else res
        return memo[i][j]
```

### Java

```java
class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, 0, 0);
    }
    int[][] memo;
    int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Math.min(
                dp(grid, i, j + 1),
                dp(grid, i + 1, j)
        ) - grid[i][j];
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
}
```

### JavaScript

```javascript
var calculateMinimumHP = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const memo = new Array(m).fill().map(() => new Array(n).fill(-1));
    function dp(i, j) {
        if (i === m - 1 && j === n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i === m || j === n) {
            return Number.MAX_VALUE;
        }
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        const res = Math.min(dp(i, j + 1), dp(i + 1, j)) - grid[i][j];
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
    return dp(0, 0);
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
