# Algorithm is like building Lego: hand-made LRU algorithm

## Core idea
# Algorithm is like building Lego: hand-made LRU algorithm
![](https://labuladong.online/algo/images/souyisou1.png)
**Notice:** In order to support more readers, this article is also listed in the [Accelerated Catalog](https://labuladong.online/algo/intro/quick-learning-plan/). For a better reading experience, you can also read the same content on my [website](https://labuladong.online/algo/).

## Approach
Implement the article strategy directly in your target language and keep state transitions explicit.

## Proof/Reasoning
The idea is valid when each step preserves the key invariant and advances toward the base or target state.

## Complexity
- Note that the `get` and `put` methods must both have a time complexity of $O(1)$. Let’s give a specific example to see how the LRU algorithm works.
- Analyzing the above operation process, in order to make the time complexity of the `put` and `get` methods O(1), we can summarize the necessary conditions for the `cache` data structure:
- At this point, we can answer the question "Why do we need to use a doubly linked list?" because we need to delete it. To delete a node, you not only need to obtain the pointer of the node itself, but also need to operate the pointer of its predecessor node. Only the doubly linked list can support direct search of the predecessor, ensuring the time complexity of the operation is O(1).

## Implementation

### Python

```python
class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = collections.OrderedDict()
    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key)
        return self.cache[key]
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            self.cache.move_to_end(key)
            return
        if len(self.cache) >= self.cap:
            self.cache.popitem(last=False)
        self.cache[key] = value
```

### Java

```java
class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, val);
    }
    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
```

### JavaScript

```javascript
var LRUCache = function(capacity) {
    this.cap = capacity;
    this.cache = new Map();
};
LRUCache.prototype.get = function(key) {
    if (!this.cache.has(key)) {
        return -1;
    }
    this.makeRecently(key);
    return this.cache.get(key);
};
LRUCache.prototype.put = function(key, value) {
    if (this.cache.has(key)) {
        this.cache.set(key, value);
        this.makeRecently(key);
        return;
    }
    if (this.cache.size >= this.cap) {
        const oldestKey = this.cache.keys().next().value;
        this.cache.delete(oldestKey);
    }
    this.cache.set(key, value);
};
LRUCache.prototype.makeRecently = function(key) {
    const val = this.cache.get(key);
    this.cache.delete(key);
    this.cache.set(key, val);
};
```

### Edge Cases
- Empty input
- Boundary values
- Duplicate entries, if applicable

## Source
- [Original source article: not included in this workspace]
