# How to arrange candidates’ seats

## Core idea
# How to arrange candidates’ seats
![](https://labuladong.online/algo/images/souyisou1.png)

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Whenever you encounter the requirement to obtain the best value in a dynamic process, you must use an ordered data structure. Our commonly used data structures are binary heaps and balanced binary search trees**. The time complexity of taking the maximum value of the priority queue implemented by the binary heap is O(logN), but only the maximum value can be deleted. A balanced binary tree can also take the maximum value, modify or delete any value, and the time complexity is O(logN).
- Because the underlying hash set/map is implemented by hash functions and arrays, the characteristic is that there is no fixed order for traversal, but the operation efficiency is high and the time complexity is O(1).
- Ordered data structures are generally used to deal with dynamic problems, such as balanced binary search trees and binary heaps. The time complexity of the two is similar, but the former supports more operations.

## Implementation

### Python

```python
class ExamRoom:
    def __init__(self, N: int):
        self.N = N
        self.startMap = {}
        self.endMap = {}
        self.pq = [(self.distance([-1, self.N]), -1, self.N)]
    def seat(self) -> int:
        dist, x, y = heapq.heappop(self.pq)
        if x == -1:
            seat = 0
        elif y == self.N:
            seat = self.N - 1
        else:
            seat = (y - x)
        heapq.heappush(self.pq, (self.distance([x, seat]), x, seat))
        heapq.heappush(self.pq, (self.distance([seat, y]), seat, y))
        self.startMap[seat] = [x, seat]
        self.endMap[seat] = [seat, y]
        return seat
    def leave(self, p: int) -> None:
        left, right = self.startMap[p], self.endMap[p]
        del self.startMap[p], self.endMap[p]
        self.pq.remove((self.distance(left), left[0], left[1]))
        self.pq.remove((self.distance(right), right[0], right[1]))
        merged = [left[0], right[1]]
        heapq.heappush(self.pq, (self.distance(merged), merged[0], merged[1]))
    def distance(self, interval: List[int]) -> int:
        x, y = interval
        if x == -1: return y
        if y == self.N: return self.N - 1 - x
        return abs(y - x)
```

### Java

```java
class ExamRoom {
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private TreeSet<int[]> pq;
    private int N;
    public ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            int distA = distance(a);
            int distB = distance(b);
            if (distA == distB)
                return b[0] - a[0];
            return distA - distB;
        });
        addInterval(new int[]{-1, N});
    }
    public int seat() {
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            seat = 0;
        } else if (y == N) {
            seat = N - 1;
        } else {
            seat = (y - x) / 2 + x;
        }
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }
    public void leave(int p) {
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        int[] merged = new int[]{left[0], right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }
    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }
    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        return (y - x) / 2;
    }
}
```

### JavaScript

```javascript
var ExamRoom = function(N) {
    this.startMap = new Map();
    this.endMap = new Map();
    this.pq = new TreeMap((a, b) => {
        let distA = this.distance(a);
        let distB = this.distance(b);
        if (distA === distB) {
            return b[0] - a[0];
        }
        return distA - distB;
    });
    this.N = N;
    this.addInterval([-1, N]);
};
ExamRoom.prototype.seat = function() {
    let longest = this.pq.last();
    let x = longest[0];
    let y = longest[1];
    let seat;
    if (x === -1) {
        seat = 0;
    } else if (y === this.N) {
        seat = this.N - 1;
    } else {
        seat = Math.floor((y - x) / 2) + x;
    }
    let left = [x, seat];
    let right = [seat, y];
    this.removeInterval(longest);
    this.addInterval(left);
    this.addInterval(right);
    return seat;
};
ExamRoom.prototype.leave = function(p) {
    let right = this.startMap.get(p);
    let left = this.endMap.get(p);
    let merged = [left[0], right[1]];
    this.removeInterval(left);
    this.removeInterval(right);
    this.addInterval(merged);
};
ExamRoom.prototype.addInterval = function(intv) {
    this.pq.add(intv);
    this.startMap.set(intv[0], intv);
    this.endMap.set(intv[1], intv);
};
ExamRoom.prototype.removeInterval = function(intv) {
    this.pq.remove(intv);
    this.startMap.delete(intv[0]);
    this.endMap.delete(intv[1]);
};
ExamRoom.prototype.distance = function(intv) {
    let x = intv[0];
    let y = intv[1];
    if (x === -1) {
        return y;
    }
    if (y === this.N) {
        return this.N - 1 - x;
    }
    return Math.floor((y - x) / 2);
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
