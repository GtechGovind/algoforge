# Fancy traversal techniques for two-dimensional arrays

## Core idea
#Fancy traversal techniques for two-dimensional arrays
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

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
    def reverseWords(self, s: str) -> str:
        sb = []
        for c in s:
            if c != ' ':
                sb.append(c)
            elif sb and sb[-1] != ' ':
                sb.append(' ')
        if sb and sb[-1] == ' ':
            sb.pop()
        chars = sb
        def reverse(l, r):
            while l < r:
                chars[l], chars[r] = chars[r], chars[l]
                l += 1
                r -= 1
        n = len(chars)
        reverse(0, n-1)
        start = end = 0
        while end < n:
            if chars[end] == ' ':
                reverse(start, end-1)
                start = end + 1
            end += 1
        reverse(start, n-1)
        return "".join(chars)
```

### Java

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        reverse(chars, 0, n - 1);
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    reverse(chars, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(chars);
    }
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

### JavaScript

```javascript
var reverseWords = function(s) {
    let sb = "";
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c !== ' ') {
            sb += c;
        } else if (sb !== "" && sb[sb.length - 1] !== ' ') {
            sb += ' ';
        }
    }
    if (sb[sb.length - 1] === ' ') {
        sb = sb.substring(0, sb.length - 1);
    }
    let chars = sb.split('');
    let n = chars.length;
    reverse(chars, 0, n - 1);
    for (let i = 0; i < n;) {
        for (let j = i; j < n; j++) {
            if (j + 1 === n || chars[j + 1] === ' ') {
                reverse(chars, i, j);
                i = j + 2;
                break;
            }
        }
    }
    return chars.join("");
};
function reverse(arr, i, j) {
    while (i < j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
