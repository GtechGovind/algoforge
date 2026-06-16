# Linked Lists

## Why linked lists matter

Think of train wagons.
Each wagon stores one value and a pointer to the next wagon.
You move by following the arrows instead of by index.

## The visual picture

```
head -> [A] -> [B] -> [C] -> None
```

## Core operations checklist

1. Create a new wagon with `value` and `next`.
2. Keep a helper pointer before changing links.
3. Save the old `next` before rewiring.
4. Return the new `head` safely.

## Anti-patterns to avoid

- lost links when rewiring
- changing shared nodes from multiple places
- assuming random access like arrays

## Kid-safe practice

Draw 4 wagons and reverse them by hand before writing code.
If your arrows are correct on paper, your implementation becomes much easier.
