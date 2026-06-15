# solution_code

## Core idea
Multi-language solution for https://leetcode.cn/problems/01-matrix👇
return res;
  }
};
```
return res
}
```

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Your algorithm should run in linear runtime complexity. Could you implement
- it using only constant extra space complexity?

## Implementation

### Python

```python
class Solution:
    def isAdditiveNumber(self, num):
        n = len(num)
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                first = num[0 : i]
                second = num[i : j]
                if self.isValid(num, first, second):
                    return True
        return False
    def isValid(self, num, first, second):
        if (first.startswith("0") and len(first) > 1) or (second.startswith("0") and len(second) > 1):
            return False
        sumStr = self.strAdd(first, second)
        next = num[len(first) + len(second):]
        if not next.startswith(sumStr):
            return False
        if next == sumStr:
            return True
        return self.isValid(num[len(first):], second, sumStr)
    def strAdd(self, a, b):
```

### Java

```java
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n; i++) {
            String first = num.substring(0, i);
            for (int j = i + 1; j <= n; j++) {
                String second = num.substring(i, j);
                if (isValid(num, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean isValid(String num, String first, String second) {
        if (first.startsWith("0") && first.length() > 1
                || second.startsWith("0") && second.length() > 1) {
            return false;
        }
        String sumStr = strAdd(first, second);
        String next = num.substring(first.length() + second.length());
        if (!next.startsWith(sumStr)) {
            return false;
        }
        if (next.equals(sumStr)) {
            return true;
        }
        return isValid(num.substring(first.length()), second, sumStr);
    }
```

### JavaScript

```javascript
var isAdditiveNumber = function(num) {
    let n = num.length;
    for (let i = 1; i <= n; i++) {
        for (let j = i + 1; j <= n; j++) {
            let first = num.substring(0, i);
            let second = num.substring(i, j);
            if (isValid(num, first, second)) {
                return true;
            }
        }
    }
    return false;
}
var isValid = function(num, first, second) {
    if ((first.startsWith("0") && first.length > 1)
            || (second.startsWith("0") && second.length > 1)) {
        return false;
    }
    let sumStr = strAdd(first, second);
    let next = num.substring(first.length + second.length);
    if (!next.startsWith(sumStr)) {
        return false;
    }
    if (next === sumStr) {
        return true;
    }
    return isValid(num.substring(first.length), second, sumStr);
}
var strAdd = function(a, b) {
    let n = a.length, m = b.length;
    let i = n - 1, j = m - 1, add = 0;
    let builder = [];
    while (i >= 0 || j >= 0 || add != 0) {
        let x = i >= 0 ? a.charAt(i) - '0' : 0;
        let y = j >= 0 ? b.charAt(j) - '0' : 0;
        let result = x + y + add;
        builder.push(result % 10);
        add = Math.floor(result / 10);
        i--;
        j--;
    }
    return builder.reverse().join('');
}
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
