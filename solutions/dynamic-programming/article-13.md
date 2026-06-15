# Perform dimensionality reduction on dynamic programming

## Core idea
# Perform dimensionality reduction on dynamic programming
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- > Space compression is not difficult and is mainly used to optimize the space complexity of certain dynamic programming problems. However, the general written test does not require high space, and you can pass it even without using this optimization technique. Therefore, I personally think that state compression is not a skill that must be mastered. Interested readers can study and understand it carefully.
- We have published many dynamic programming articles. In short, DP can often turn exponential or factorial solutions into much more efficient ones, often around $O(N^2)$ through the right state definition and transitions. A useful way to think about this is turning a multi-parameter problem into a 2D DP formulation.
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
