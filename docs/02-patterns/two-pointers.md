# Pattern: Two Pointers

## Use cases

- sorted array pair search
- removing duplicates / stable partition
- reversing in-place structures

## Template

```text
sort or define monotonic relation
left = 0
right = n - 1
while left < right:
  if condition(left, right):
    left++, right--
  elif condition_to_shrink_left:
    left++
  else:
    right--
```

## Why it works

Each step shrinks the search space by one due to monotonic relationship between indices and target property.
