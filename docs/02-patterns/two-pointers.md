# Pattern: Two Pointers

## Kid-friendly idea

Use two helpers at the ends of a line.
Move them closer one step at a time.

```
L....................................R
```

## Use cases

- sorted pair search
- remove duplicates
- in-place reverse or partition

## Template

```text
sort or define order rule
L = 0
R = n - 1
while L < R:
  if good(L, R):
    move both inward
  elif need_more_from_left:
    L += 1
  else:
    R -= 1
```

## Why it works

At every step, you throw away one impossible area.
That means less work and clearer progress.
