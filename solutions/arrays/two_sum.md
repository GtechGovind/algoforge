# Two Sum

## Why this is a template problem

It teaches hash-map indexing and single-pass reasoning, used in many future arrays + two-sum variants.

## Approach

Use complement lookup: for each `num`, check if `target - num` exists in map.

## Complexity

- Time: O(n)
- Space: O(n)

## Language coverage

- Python: `code/python/two_sum.py`
- Java: `code/java/TwoSum.java`
- JavaScript: `code/javascript/twoSum.js`
