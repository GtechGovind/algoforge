# Searching for Him in the Public on Thousands of Baidu: Problems with Celebrities

## Core idea
# Searching for Him in the Public on Thousands of Baidu: Problems with Celebrities
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- As mentioned just now, the bottom layer of the `knows` function is to access a two-dimensional adjacency matrix. The time complexity of a call is O(1), so the overall worst-case time complexity of this brute force solution is O(N^2).
- So, are there other clever ways to optimize time complexity? In fact, there is room for optimization. Think about it, where is the most time-consuming part of us now?
- Because the definition of "celebrity" ensures the uniqueness of "celebrity", we can use the elimination method to first exclude those who are obviously not "celebrities", thereby avoiding the nesting of for loops and reducing time complexity**.
- ```This algorithm avoids nested for loops and reduces the time complexity to O(N), but introduces a queue to store the candidate set, using a space complexity of O(N).

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
