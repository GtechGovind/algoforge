# How to find prime numbers efficiently

## Core idea
# How to find prime numbers efficiently
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```If written like this, the time complexity is O(n^2), which is a big problem. **First of all, your idea of ​​using the `isPrime` function to assist is not efficient enough; and even if you want to use the `isPrime` function, there is computational redundancy in writing the algorithm like this**.
- Now, the time complexity of the `isPrime` function is reduced to $O(sqrt(N))$, **but we do not actually need this function to implement the `countPrimes` function**. The above just hopes that readers understand the meaning of `sqrt(n)`, because it will be used later.
- The time complexity of this algorithm is difficult to calculate**. Obviously the time is related to these two nested for loops, and its operands should be:
- In parentheses are the reciprocals of prime numbers. The final result is $O(N * loglogN)$. Interested readers can check the time complexity proof of this algorithm.

## Implementation

### Python

```python
class Solution:
    def countPrimes(self, n: int) -> int:
        isPrime = [True]*n
        for i in range(2, int(n**0.5)+1):
            if isPrime[i]:
                for j in range(i*i, n, i):
                    isPrime[j] = False
        count = 0
        for i in range(2, n):
            if isPrime[i]:
                count += 1
        return count
```

### Java

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;
        return count;
    }
}
```

### JavaScript

```javascript
var countPrimes = function(n) {
    const isPrime = new Array(n).fill(true);
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
