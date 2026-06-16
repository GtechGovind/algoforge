/**
 * Core program of binary tree series algorithms
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return maxDepth(...args);
}

function maxDepth(root) {
    let depth = 0;
    let res = 0;
    function traverse(root) {
        if (root === null) {
        return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
    traverse(root);
    return res;
}
function maxDepth2(root) {
    if (root === null) {
        return 0;
    }
    const leftMax = maxDepth2(root.left);
    const rightMax = maxDepth2(root.right);
    return 1 + Math.max(leftMax, rightMax);
}
