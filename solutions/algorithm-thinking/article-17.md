# Backtracking algorithm practice: set partitioning

## Core idea
# Backtracking algorithm practice: set partitioning
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- If we let as many situations as possible hit the pruned if branch, we can reduce the number of recursive calls and reduce the time complexity to a certain extent**.
- Let's analyze the time complexity of these two algorithms, assuming that the number of elements in `nums` is `n`.
- Let’s talk about the first solution first, that is, exhaustive enumeration from a numerical perspective, `n` numbers, each number has `k` buckets to choose from, so the number of combined results is `k^n`, and the time complexity is $O(k^n)$.
- In the second solution, each bucket needs to traverse `n` numbers, and there are two choices of "loading" or "not loading" for each number, so there are `2^n` kinds of combination results; and we have `k` buckets, so the total time complexity is $O(k*2^n)$.

## Implementation

### Python

```python
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if k > len(nums):
            return False
        _sum = sum(nums)
        if _sum % k != 0:
            return False
        used = 0
        target = _sum
        return self.backtrack(k, 0, nums, 0, used, target, {})
    def backtrack(self, k: int, bucket: int, nums: List[int], start: int, used: int, target: int, memo: Dict[int, bool]) -> bool:
        if k == 0:
            return True
        if bucket == target:
            if used in memo:
                return memo[used]
            res = self.backtrack(k - 1, 0, nums, 0, used, target, memo)
            memo[used] = res
            return res
        for i in range(start, len(nums)):
            if used >> i & 1 == 1:
                continue
            if nums[i] + bucket > target:
                continue
            used |= 1 << i
            bucket += nums[i]
            if self.backtrack(k, bucket, nums, i + 1, used, target, memo):
                return True
            used ^= 1 << i
            bucket -= nums[i]
        return False
```

### Java

```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;
        int used = 0;
        int target = sum / k;
        return backtrack(k, 0, nums, 0, used, target);
    }
    HashMap<Integer, Boolean> memo = new HashMap<>();
    boolean backtrack(int k, int bucket,
                    int[] nums, int start, int used, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            used |= 1 << i;
            bucket += nums[i];
            ![](../pictures
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used ^= 1 << i;
            bucket -= nums[i];
        }
        return false;
    }
}
```

### JavaScript

```javascript
var canPartitionKSubsets = function(nums, k) {
    let memo = new Map();
    function backtrack(k, bucket, nums, start, used, target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            let res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.set(used, res);
            return res;
        }
        if (memo.has(used)) {
            return memo.get(used);
        }
        for (let i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            let newUsed = used | (1 << i);
            let newBucket = bucket + nums[i];
            ![](../pictures
            if (backtrack(k, newBucket, nums, i + 1, newUsed, target)) {
                return true;
            }
            newUsed ^= (1 << i);
            newBucket -= nums[i];
        }
        memo.set(used, false);
        return false;
    }
    if (k > nums.length) return false;
    let sum = 0;
    for (let v of nums) sum += v;
    if (sum % k != 0) return false;
    let used = 0;
    let target = sum / k;
    return backtrack(k, 0, nums, 0, used, target);
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
