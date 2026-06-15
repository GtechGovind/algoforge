# Backtracking algorithm instantly kills all permutation/combination/subset problems

## Core idea
# Backtracking algorithm instantly kills all permutation/combination/subset problems
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- If you can see this, I really applaud you. I believe that when you encounter all kinds of messy algorithm problems in the future, you will be able to see their essence at a glance and stay the same to cope with the changes. In addition, considering the length, this article does not analyze the complexity of these algorithms. You can use the complexity analysis method I mentioned in [A Practical Guide to Algorithm Space-Time Complexity Analysis](https://labuladong.online/algo/essential-technique/complexity-analysis/) to try to analyze their complexity yourself.
- [Practical Guide to Algorithm Space-Time Complexity Analysis](https://labuladong.online/algo/essential-technique/complexity-analysis/)

## Implementation

### Python

```python
class Solution:
    def __init__(self):
        self.res = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.res
        self.backtrack(candidates, 0, target, 0)
        return self.res
    track = []
    def backtrack(self, candidates, start, target, sum):
        if sum == target:
            self.res.append(self.track[:])
            return
        if sum > target:
            return
        for i in range(start, len(candidates)):
            self.track.append(candidates[i])
            sum += candidates[i]
            self.backtrack(candidates, i, target, sum)
            sum -= candidates[i]
            self.track.pop()
```

### Java

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }
    LinkedList<Integer> track = new LinkedList<>();
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, target, sum);
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
```

### JavaScript

```javascript
var combinationSum = function(candidates, target) {
    let res = [];
    let track = [];
    backtrack(candidates, 0, target, 0, track);
    return res;
    function backtrack(candidates, start, target, sum, track) {
        if (sum === target) {
            res.push([...track]);
            return;
        }
        if (sum > target) {
            return;
        }
        for (let i = start; i < candidates.length; i++) {
            track.push(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, target, sum, track);
            sum -= candidates[i];
            track.pop();
        }
    }
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
