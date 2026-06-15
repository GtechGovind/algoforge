# How to find missing and duplicate elements at the same time

## Core idea
# How to find missing and duplicate elements at the same time
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- But the problem is that this conventional solution requires a hash table, which is O(N) space complexity. You see, the conditions given in the question are so coincidental. Among the numbers in `[1..N]`, there happens to be one duplication and one missing. If something goes wrong, there must be a monster, right?
- The O(N) time complexity of traversing the array is unavoidable, so we can think of ways to reduce the space complexity. Can we find duplicate and missing elements under the O(1) space complexity?

## Implementation

### Python

```python
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        dup = -1
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] < 0:
                dup = abs(nums[i])
            else:
                nums[index] *= -1
        missing = -1
        for i in range(n):
            if nums[i] > 0:
                missing = i + 1
        return [dup, missing]
```

### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }
        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                missing = i + 1;
        return new int[]{dup, missing};
    }
}
```

### JavaScript

```javascript
var findErrorNums = function(nums) {
    var n = nums.length;
    var dup = -1;
    for (var i = 0; i < n; i++) {
        var index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0)
            dup = Math.abs(nums[i]);
        else
            nums[index] *= -1;
    }
    var missing = -1;
    for (var i = 0; i < n; i++)
        if (nums[i] > 0)
            missing = i + 1;
    return [dup, missing];
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
