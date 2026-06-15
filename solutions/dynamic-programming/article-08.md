# Thinking transformation between dynamic programming and backtracking algorithms

## Core idea
# Thinking transformation between dynamic programming and backtracking algorithms
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- ```This code is written strictly in accordance with the backtracking algorithm framework and should not be difficult to understand. However, this code cannot pass all test cases. We analyze its time complexity according to the method mentioned in [Algorithm Space-Time Complexity Usage Guide](https://labuladong.online/algo/essential-technique/complexity-analysis/).
- A rough estimate of the time complexity of a recursive function is to use the number of calls to the recursive function (the number of nodes in the recursive tree) x the complexity of the recursive function itself. For this question, each node of the recursive tree is actually a cut of `s`. So how many cuts can `s` have in the worst case? There are `N - 1` "gaps" in the string `s` of length `N` that can be cut. Each gap can be cut or not cut, so `s` has at most $O(2^N)$ cutting methods, that is, there are at most $O(2^N)$ nodes on the recursive tree.
- Of course, the actual situation may be better, after all, there is pruning logic, but from the perspective of worst-case complexity, the number of nodes in the recursive tree is indeed exponential.
- So what is the time complexity of the `backtrack` function itself? The main time consuming is traversing `wordDict` to find words matching the prefix of `s[i..]`:

## Implementation

### Python

```python
class Solution:
    def __init__(self):
        self.res = []
        self.track = []
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        self.backtrack(s, 0, wordDict)
        return self.res
    def backtrack(self, s: str, i: int, wordDict: List[str]) -> None:
        if i == len(s):
            self.res.append(" ".join(self.track))
            return
        if i > len(s):
            return
        for word in wordDict:
            length = len(word)
            if i + length > len(s):
                continue
            sub_str = s[i:i + length]
            if sub_str != word:
                continue
            self.track.append(word)
            self.backtrack(s, i + length, wordDict)
            self.track.pop()
```

### Java

```java
class Solution {
    List<String> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, 0, wordDict);
        return res;
    }
    void backtrack(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            res.add(String.join(" ", track));
            return;
        }
        if (i > s.length()) {
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            track.addLast(word);
            backtrack(s, i + len, wordDict);
            track.removeLast();
        }
    }
}
```

### JavaScript

```javascript
var wordBreak = function(s, wordDict) {
  let res = [];
  let track = [];
  function backtrack(s, i, wordDict) {
    if (i === s.length) {
      res.push(track.join(" "));
      return;
    }
    if (i > s.length) {
      return;
    }
    for (let word of wordDict) {
      let len = word.length;
      if (i + len > s.length) {
        continue;
      }
      let subStr = s.substring(i, i + len);
      if (subStr !== word) {
        continue;
      }
      track.push(word);
      backtrack(s, i + len, wordDict);
      track.pop();
    }
  }
  backtrack(s, 0, wordDict);
  return res;
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
