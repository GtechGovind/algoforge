# Interval scheduling problem of greedy algorithm

## Core idea
# Interval scheduling problem of greedy algorithm
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- For example, an algorithmic problem requires exponential time to be solved using brute force. If dynamic programming can be used to eliminate overlapping sub-problems, the time can be reduced to the polynomial level. If the greedy selection property is satisfied, the time complexity can be further reduced to the linear level.

## Implementation

### Python

```python
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        return n - self.intervalSchedule(intervals)
    def intervalSchedule(self, intvs: List[List[int]]) -> int:
        if len(intvs) == 0:
            return 0
        intvs = sorted(intvs, key=lambda x:x[1])
        count = 1
        x_end = intvs[0][1]
        for interval in intvs:
            start = interval[0]
            if start >= x_end:
                count += 1
                x_end = interval[1]
        return count
```

### Java

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }
    int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
```

### JavaScript

```javascript
var eraseOverlapIntervals = function(intervals) {
    var n = intervals.length;
    return n - intervalSchedule(intervals);
};
var intervalSchedule = function(intvs) {
    if (intvs.length === 0) return 0;
    intvs.sort((a, b) => a[1] - b[1]);
    var count = 1;
    var x_end = intvs[0][1];
    for (var i = 1; i < intvs.length; i++) {
        var start = intvs[i][0];
        if (start >= x_end) {
            count++;
            x_end = intvs[i][1];
        }
    }
    return count;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
