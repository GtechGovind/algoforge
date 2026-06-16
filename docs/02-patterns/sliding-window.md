# Pattern: Sliding Window

## Kid-friendly idea

Think of a magnifying glass over a row.
The glass moves right one block at a time.
If the window is too full or invalid, shrink from the left.

```text
L
[a b c d e f g]
      R
```

## Ideal for

- longest/shortest substring or subarray
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
