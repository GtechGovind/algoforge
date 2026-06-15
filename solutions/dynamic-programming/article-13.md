# Perform dimensionality reduction on dynamic programming

## Core idea
# Perform dimensionality reduction on dynamic programming
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- > Space compression is not difficult and is mainly used to optimize the space complexity of certain dynamic programming problems. However, the general written test does not require high space, and you can pass it even without using this optimization technique. Therefore, I personally think that state compression is not a skill that must be mastered. Interested readers can study and understand it carefully.
- Our account has written more than a dozen dynamic programming articles before. It can be said that dynamic programming techniques can greatly improve the efficiency of algorithms. Generally speaking, algorithms with exponential and factorial time complexity can be optimized to O(N^2). It can be called a two-way foil in the algorithm world, turning all kinds of monsters into two dimensions.
- However, staged optimization can also be performed during the process of dynamic programming solving. If you carefully observe the state transition equations of some dynamic programming problems, you can further reduce the space complexity of their solutions from O(N^2) to O(N).
- Dynamic programming that can use space compression techniques is a two-dimensional `dp` problem. **Look at its state transition equation. If the calculation of state `dp[i][j]` requires all `dp[i][j]` adjacent states, then you can use space compression techniques** to convert the two-dimensional `dp` array into one dimension, reducing the space complexity from O(N^2) to O(N).

## Implementation

### Python

```python
def solve(*args, **kwargs):
    """Starter implementation for this topic."""
    return None
```

### Java

```java
class Solution {
    public void solve() {
        return null; // Placeholder implementation
    }
}
```

### JavaScript

```javascript
function solve() {
    return null; // Placeholder implementation
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
