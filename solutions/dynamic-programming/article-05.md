# Classic dynamic programming: regular expressions

## Core idea
# Classic dynamic programming: regular expressions
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The time complexity of dynamic programming is "the total number of states" * "the time spent in each recursion". The total number of states in this question is of course the combination of `i` and `j`, that is, `M * N` (`M` is the length of `s`, `N` is the length of `p`); there are no loops in the recursive function `dp` (the ones in the base case are not considered, because the base case The number of triggers is limited), so the time spent in one recursion is constant. Multiplying the two, the total time complexity is $O(MN)$.
- The space complexity is simply the size of the memo `memo`, which is $O(MN)$.

## Implementation

### Python

```python
class Solution:
    memo = []
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        self.memo = [[-1] * n for _ in range(m)]
        return self.dp(s, 0, p, 0)
    def dp(self, s: str, i: int, p: str, j: int) -> bool:
        m, n = len(s), len(p)
        if j == n:
            return i == m
        if i == m:
            if (n - j) % 2 == 1:
                return False
            for k in range(j + 1, n, 2):
                if p[k] != '*':
                    return False
            return True
        if self.memo[i][j] != -1:
            return self.memo[i][j]
        res = False
        if s[i] == p[j] or p[j] == '.':
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2) or self.dp(s, i + 1, p, j)
            else:
                res = self.dp(s, i + 1, p, j + 1)
        else:
            if j < n - 1 and p[j + 1] == '*':
                res = self.dp(s, i, p, j + 2)
            else:
                res = False
        self.memo[i][j] = res
        return res
```

### Java

```java
class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(s, 0, p, 0);
    }
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2)
                        || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
```

### JavaScript

```javascript
var isMatch = function(s, p) {
    let m = s.length, n = p.length;
    let memo = new Array(m + 1);
    for (let i = 0; i < memo.length; i++) {
        memo[i] = new Array(n + 1).fill(-1);
    }
    return dp(0, 0);
    function dp(i, j) {
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        let res = false;
        if (j === n) {
            res = i === m;
        } else {
            let firstMatch = i < m && (p[j] === s[i] || p[j] === '.');
            if (j + 1 < n && p[j + 1] === '*') {
                res = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
            } else {
                res = firstMatch && dp(i + 1, j + 1);
            }
        }
        memo[i][j] = res;
        return res;
    }
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
