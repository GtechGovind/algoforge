# Linked Lists

## Why linked lists matter

They are the easiest way to learn pointer-like reasoning before recursion, tree, and graph traversal.

## Core operations checklist

1. create sentinel node
2. define iteration invariant
3. preserve `next` while rewiring
4. return new head and tail safely

## Anti-patterns to avoid

- losing references during pointer updates
- mutating shared nodes unexpectedly in recursive paths
- assuming random access like arrays
