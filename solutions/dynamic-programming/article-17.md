# Classic dynamic programming: throwing eggs from high-rise buildings

## Core idea
# Classic dynamic programming: throwing eggs from high-rise buildings
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- What is the time complexity of this algorithm? **The time complexity of the dynamic programming algorithm is the number of sub-problems × the complexity of the function itself**.
- The complexity of the function itself is the complexity of ignoring the recursive part. There is a for loop in the `dp` function, so the complexity of the function itself is O(N).
- The number of sub-problems is the total number of different state combinations, which is obviously the product of two states, which is O(KN). So the total time complexity of the algorithm is O(K*N^2), and the space complexity is O(KN).
- In addition, there are better solutions to this problem. For example, modifying the for loop in the code to binary search can reduce the time complexity to O(K\*N\*logN); improving the dynamic programming solution can further reduce it to O(KN); using mathematical methods to solve it, the time complexity reaches the optimal O(K*logN) and the space complexity reaches O(1).

## Implementation

### Python

```python
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        dp = [[0] * (N + 1) for _ in range(K + 1)]
        m = 0
        while dp[K][m] < N:
            m += 1
            for k in range(1, K + 1):
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
        return m
```

### Java

```java
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }
}
```

### JavaScript

```javascript
var superEggDrop = function(K, N) {
    var dp = new Array(K + 1).fill(0).map(x => new Array(N + 1).fill(0));
    var m = 0;
    while (dp[K][m] < N) {
        m++;
        for (var k = 1; k <= K; k++)
            dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
    }
    return m;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
