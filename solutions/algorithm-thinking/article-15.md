# Shaobing sorting algorithm

## Core idea
# Shaobing sorting algorithm
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice: In order to meet the needs of readers, the website has put quick learning plan on the website. If necessary, you can take a look. Thank you for your support. In addition, I recommend that you study articles on my website for a better experience. **

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- The time complexity of the algorithm is easy to calculate, because the number of recursive calls is `n`, each recursive call requires a for loop, and the time complexity is O(n), so the total complexity is O(n^2).

## Implementation

### Python

```python
class Solution:
    def __init__(self):
        self.res = []
    def pancakeSort(self, cakes: List[int]) -> List[int]:
        self.sort(cakes, len(cakes))
        return self.res
    def sort(self, cakes: List[int], n: int) -> None:
        if n == 1:
            return
        maxCake = 0
        maxCakeIndex = 0
        for i in range(n):
            if cakes[i] > maxCake:
                maxCakeIndex = i
                maxCake = cakes[i]
        self.reverse(cakes, 0, maxCakeIndex)
        self.res.append(maxCakeIndex + 1)
        self.reverse(cakes, 0, n - 1)
        self.res.append(n)
        self.sort(cakes, n - 1)
    def reverse(self, arr: List[int], i: int, j: int) -> None:
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

### Java

```java
class Solution {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }
    void sort(int[] cakes, int n) {
        if (n == 1) return;
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++)
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        reverse(cakes, 0, n - 1);
        res.add(n);
        ![](../pictures/pancakeSort/3.jpg)
        sort(cakes, n - 1);
        ![](../pictures/pancakeSort/4.jpg)
    }
    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
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
var pancakeSort = function(cakes) {
    const res = [];
    sort(cakes, cakes.length);
    return res;
    function sort(cakes, n) {
        if (n == 1) return;
        let maxCake = 0;
        let maxCakeIndex = 0;
        for (let i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }
        reverse(cakes, 0, maxCakeIndex);
        res.push(maxCakeIndex + 1);
        reverse(cakes, 0, n - 1);
        res.push(n);
        sort(cakes, n - 1);
    }
    function reverse(arr, i, j) {
        while (i < j) {
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
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
