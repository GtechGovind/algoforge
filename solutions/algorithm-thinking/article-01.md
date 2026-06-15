# BFS Algorithm Problem Solving Routine Framework

## Core idea
# BFS Algorithm Problem Solving Routine Framework
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). Thank you for your support. For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

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
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        visited = set()
        q = collections.deque()
        step = 0
        q.append("0000")
        visited.add("0000")
        while q:
            sz = len(q)
            for i in range(sz):
                cur = q.popleft()
                if cur in deads:
                    continue
                if cur == target:
                    return step
                for j in range(4):
                    up = plusOne(cur,j)
                    if up not in visited:
                        q.append(up)
                        visited.add(up)
                    down = minusOne(cur,j)
                    if down not in visited:
                        q.append(down)
                        visited.add(down)
            step += 1
        return -1
    def plusOne(s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '9':
            ch[j] = '0'
        else:
            ch[j] = chr(ord(ch[j])+1)
        return "".join(ch)
    def minusOne(s: str, j: int) -> str:
        ch = list(s)
        if ch[j] == '0':
            ch[j] = '9'
        else:
            ch[j] = chr(ord(ch[j])-1)
        return "".join(ch)
```

### Java

```java
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
```

### JavaScript

```javascript
var openLock = function(deadends, target) {
  const deads = new Set(deadends);
  const visited = new Set();
  const q = [];
  let step = 0;
  q.push("0000");
  visited.add("0000");
  while (q.length > 0) {
    let sz = q.length;
    for (let i = 0; i < sz; i++) {
      let cur = q.shift();
      if (deads.has(cur)) continue;
          if (cur === target) return step;
      for (let j = 0; j < 4; j++) {
        let up = plusOne(cur, j);
        if (!visited.has(up)) {
          q.push(up);
          visited.add(up);
        }
        let down = minusOne(cur, j);
        if (!visited.has(down)) {
          q.push(down);
          visited.add(down);
        }
      }
    }
    step++;
  }
  return -1;
}
function plusOne(s, j) {
  let ch = s.split("");
  if (ch[j] === "9") ch[j] = "0";
  else ch[j] = String(+ch[j]+1);
  return ch.join("");
}
function minusOne(s, j) {
  let ch = s.split("");
  if (ch[j] === "0") ch[j] = "9";
  else ch[j] = String(+ch[j]-1);
  return ch.join("");
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
