# Pattern: Dynamic Programming

## Three checkpoints before coding

1. Identify state variables
2. Define transitions
3. Define traversal order and base states

## State design checklist

- can the state be minimized to 1D?
- do overlapping subproblems appear?
- can transition be derived from smaller states with proof

## Template

```text
dp = [base values]
for i in states:
  for j in transitions:
    dp[i] = merge(dp[i], combine(dp[i-1], dp[j]))
```
