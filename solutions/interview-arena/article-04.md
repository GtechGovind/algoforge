# Binary search efficiently determines subsequences

## Core idea
#Binary search efficiently determines subsequences
![](https://labuladong.online/algo/images/souyisou1.png)

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Readers may ask, isn't this the optimal solution? The time complexity is only O(N), where N is the length of `t`.
- Yes, but the time complexity of this solution to process each `s` is still O(N). If you use binary search cleverly, the time complexity can be reduced to about O(MlogN). Since N is much larger than M, the latter will be more efficient.

## Implementation

### Python

```python
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i, j = 0, 0
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
            j += 1
        return i == len(s)
```

### Java

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
```

### JavaScript

```javascript
var isSubsequence = function(s, t) {
    let i = 0, j = 0;
    while (i < s.length && j < t.length) {
        if (s.charAt(i) === t.charAt(j)) {
            i++;
        }
        j++;
    }
    return i === s.length;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
