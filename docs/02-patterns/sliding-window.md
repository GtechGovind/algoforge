# Pattern: Sliding Window

## Ideal for

- longest/shortest substring and subarray
- counting windows with constraints
- frequency-based optimization

## Template skeleton

```text
l = 0
counter = initialize_window_counter()
for r in range(n):
  add(nums[r])
  while window_is_invalid():
    remove(nums[l])
    l += 1
  update_answer()
```

## Mistake detector

- shrinking too early (missing optimal window)
- forgetting to handle duplicates
- treating characters/nums as booleans without counts when duplicates matter
