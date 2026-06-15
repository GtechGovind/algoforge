# 差分技巧

## Core idea
![](https://labuladong.online/algo/images/souyisou1.png)
**-----------**
// 输入一个数组，构造前缀和
  public PrefixSum(int[] nums) {
// preSum[0] = 0，便于计算累加和
    preSum = new int[nums.length + 1];
// 计算 nums 的累加和
    for (int i = 1; i < preSum.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i - 1];
    }
  }
  
// 查询闭区间 [left, right] 的累加和
  public int sumRange(int left, int right) {
    return preSum[right + 1] - preSum[left];
  }
}
```

## Approach
This article is concept-first; convert the described pattern into a concrete routine.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Time: O(?)
- Space: O(?)

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
