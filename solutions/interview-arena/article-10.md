# Kill all island questions with one article

## Core idea
# Kill all island questions with one article
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
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for i in range(m):
            self.dfs(grid, i, 0)
            self.dfs(grid, i, n - 1)
        for j in range(n):
            self.dfs(grid, 0, j)
            self.dfs(grid, m - 1, j)
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res += 1
        return res
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
            return
        grid[i][j] = 0
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

### Java

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

### JavaScript

```javascript
var numEnclaves = function(grid) {
    var m = grid.length, n = grid[0].length;
    for (var i = 0; i < m; i++) {
        dfs(grid, i, 0);
        dfs(grid, i, n - 1);
    }
    for (var j = 0; j < n; j++) {
        dfs(grid, 0, j);
        dfs(grid, m - 1, j);
    }
    var res = 0;
    for (var row = 0; row < m; row++) {
        for (var col = 0; col < n; col++) {
            if (grid[row][col] === 1) {
                res += 1;
            }
        }
    }
    return res;
};
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] === 0) {
        return;
    }
    grid[i][j] = 0;
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
