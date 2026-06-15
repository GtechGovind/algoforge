# Sliding window algorithm core code template

## Core idea
# Sliding window algorithm core code template
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- If you use brute force to solve it, you need to nest for loops to exhaustively enumerate all sub-arrays, and the time complexity is $O(N^2)$:
- The time complexity of the code written based on the sliding window algorithm framework is $O(N)$, which is more efficient than the brute force solution of nested for loops.
- Some readers must be asking, doesn’t your sliding window framework also use a nested while loop? Why is the complexity $O(N)$?
- Simply put, the pointers `left, right` will not go back (their values ​​only increase but not decrease), so each element in the string/array will only enter the window once, and then be moved out of the window once. It will not be said that some elements enter and leave the window multiple times, so the time complexity of the algorithm is proportional to the length of the string/array.

## Implementation

### Python

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = {}
        left = right = 0
        res = 0
        while right < len(s):
            c = s[right]
            right += 1
            window[c] = window.get(c, 0) + 1
            while window[c] > 1:
                d = s[left]
                left += 1
                window[d] -= 1
            res = max(res, right - left)
        return res
```

### Java

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
```

### JavaScript

```javascript
var lengthOfLongestSubstring = function(s) {
    let window = new Map();
    let left = 0, right = 0, res = 0;
    while (right < s.length) {
        let c = s[right];
        right++;
        window.set(c, (window.get(c) || 0) + 1);
        while (window.get(c) > 1) {
            let d = s[left];
            left++;
            window.set(d, window.get(d) - 1);
        }
        res = Math.max(res, right - left);
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
