# Commonly used bit operations

## Core idea
#Commonly used bit operations
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The time complexity of the sorting solution is O(NlogN), and the time complexity of the HashSet solution is O(N), but it also requires O(N) space complexity to store the HashSet.

## Implementation

### Python

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for n in nums:
            res ^= n
        return res
```

### Java

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
```

### JavaScript

```javascript
var singleNumber = function(nums) {
    let res = 0;
    for (let n of nums) {
        res ^= n;
    }
    return res;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
