# Algorithm problems that can be solved with one line of code

## Core idea
# Algorithm problems that can be solved with one line of code
![](https://labuladong.online/algo/images/souyisou1.png)

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
    def canWinNim(self, n: int) -> bool:
        return n % 4 != 0
```

### Java

```java
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
```

### JavaScript

```javascript
var canWinNim = function(n) {
    return n % 4 !== 0;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
