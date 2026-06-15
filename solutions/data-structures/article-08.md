# Monotone stack algorithm template to solve three example problems

## Core idea
# Monotone stack algorithm template to solve three example problems
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The violent solution to this problem is easy to think of, that is, scan the back of each element and find the first larger element. But the time complexity of the brute force solution is $O(n^2)$.
- The time complexity of this algorithm is not so intuitive. If you see a for loop nested in a while loop, you may think that the complexity of this algorithm is also $O(n^2)$, but in fact the complexity of this algorithm is only $O(n)$.
- To analyze its time complexity, we need to look at it as a whole: there are `n` elements in total, each element is pushed onto the stack once by `push`, and will be `pop` once at most, without any redundant operations. Therefore, the total calculation scale is proportional to the element size `n`, which is the complexity of $O(n)$.
- In this way, the problem of circular arrays can be cleverly solved with a time complexity of $O(N)$.

## Implementation

### Python

```python
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        greater = self.nextGreater(nums2)
        greaterMap = {}
        for i in range(len(nums2)):
            greaterMap[nums2[i]] = greater[i]
        res = []
        for num in nums1:
            res.append(greaterMap[num])
        return res
    def nextGreater(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * n
        s = []
        for i in range(n - 1, -1, -1):
            while s and s[-1] <= nums[i]:
                s.pop()
            if s:
                res[i] = s[-1]
            s.append(nums[i])
        return res
```

### Java

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
```

### JavaScript

```javascript
var nextGreaterElement = function(nums1, nums2) {
    var greater = nextGreater(nums2);
    var greaterMap = new Map();
    for (var i = 0; i < nums2.length; i++) {
        greaterMap.set(nums2[i], greater[i]);
    }
    var res = new Array(nums1.length);
    for (var i = 0; i < nums1.length; i++) {
        res[i] = greaterMap.get(nums1[i]);
    }
    return res;
};
var nextGreater = function(nums) {
    var n = nums.length;
    var res = new Array(n);
    var s = [];
    for (var i = n - 1; i >= 0; i--) {
        while (s.length && s[s.length-1] <= nums[i]) {
            s.pop();
        }
        res[i] = s.length == 0 ? -1 : s[s.length-1];
        s.push(nums[i]);
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
