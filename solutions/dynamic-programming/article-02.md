# Dynamic programming KMP character matching algorithm

## Core idea
# Dynamic programming KMP character matching algorithm
![](https://labuladong.online/algo/images/souyisou1.png)

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The KMP algorithm that readers have seen should be that a wave of weird operations process `pat` to form a one-dimensional array `next`, and then go through another wave of complex operations to match `txt` based on this array. Time complexity O(N), space complexity O(M). In fact, the `next` array is equivalent to the `dp` array. The meaning of the elements is related to the prefix and suffix of `pat`. The determination rules are complicated and difficult to understand. **This article uses a two-dimensional `dp` array (but the space complexity is still O(M)) to redefine the meaning of the elements, greatly reducing the code length and greatly improving the interpretability**.
- ```For the brute force algorithm, if there is a mismatched character, the pointers of `txt` and `pat` are rolled back at the same time, and the nested for loop has a time complexity of `O(MN)` and a space complexity of `O(1)`. The main problem is that this algorithm becomes stupid if there are many repeated characters in the string.
- The KMP algorithm never rolls back the pointer `i` of `txt`, and does not go back (it will not scan `txt` repeatedly), but uses the information stored in the `dp` array to move `pat` to the correct position to continue matching**. The time complexity is only O(N), and space is exchanged for time, so I think it is a dynamic programming algorithm.
- The traditional KMP algorithm uses a one-dimensional array `next` to record prefix information, while this article uses a two-dimensional array `dp` to solve the character matching problem from the perspective of state transition, but the space complexity is still O(256M) = O(M).

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
