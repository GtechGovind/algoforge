# Arrays and Prefix Thinking

## Why arrays are first

Imagine a row of toy boxes.
Each box has a number label and you can open only by position.
Arrays are exactly this row.

## The beginner mental model

1. Every item has an `index`.
2. Indexes start at `0`.
3. `index + 1` is the next box.

## Visual template

```
index: 0   1   2   3
value: 4   1   9   3
```

## Core ideas for this section

- read by index pattern (scan left to right)
- in-place mutation (change value inside the same box)
- simple prefix and difference ideas
- quick checks before using nested loops

## Common mistakes (and visual fix)

- index out of bounds: draw the last index number and never cross it.
- forgotten middle: for split logic, mark left and right zones clearly.
- too many nested loops: stop when your drawn index map stops giving new information.

## 5-minute practice

Input: `[2, 1, 4, 3]`  
Task: find sum of every pair of neighbors.

Draw:

```
2+1, 1+4, 4+3
```

Then write one short function.
