/**
 * Binary tree mental method (ideas)
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return flatten(...args);
}

var flatten = function(root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    var left = root.left;
    var right = root.right;
    root.left = null;
    root.right = left;
    var p = root;
    while (p.right != null) {
        p = p.right;
    }
    p.right = right;
};
