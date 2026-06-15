# Dynamic programming problem-solving routine framework

## Core idea
# Dynamic programming problem-solving routine framework
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- > Whenever you encounter a problem that requires recursion, it is best to draw a recursion tree. This will be of great help to you in analyzing the complexity of the algorithm and finding the reasons for the inefficiency of the algorithm.
- How ​​to calculate the time complexity of recursive algorithm? Just multiply the number of sub-problems by the time required to solve one sub-problem**.
- Therefore, the time complexity of this algorithm is the product of the two, that is, O(2^n), exponential level, explosion.
- How ​​to calculate the time complexity of recursive algorithm? Just multiply the number of sub-problems by the time required to solve one sub-problem**.

## Implementation

### Python

```python
class Solution:
    def __init__(self):
        self.memo = []
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.memo = [-666] * (amount + 1)
        return self.dp(coins, amount)
    def dp(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        if amount < 0:
            return -1
        if self.memo[amount] != -666:
            return self.memo[amount]
        res = float("inf")
        for coin in coins:
            sub_problem = self.dp(coins, amount - coin)
            if sub_problem == -1:
                continue
            res = min(res, sub_problem + 1)
        self.memo[amount] = -1 if res == float("inf") else res
        return self.memo[amount]
```

### Java

```java
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }
    int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666)
            return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            ![](../pictures
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
```

### JavaScript

```javascript
var coinChange = function(coins, amount) {
    let memo = new Array(amount + 1).fill(-666);
    return dp(coins, amount);
    function dp(coins, amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666)
            return memo[amount];
        let res = Number.MAX_SAFE_INTEGER;
        for (let coin of coins) {
            let subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Number.MAX_SAFE_INTEGER) ? -1 : res;
        return memo[amount];
    }
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
