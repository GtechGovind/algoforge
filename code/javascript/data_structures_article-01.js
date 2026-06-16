/**
 * Binary Search Tree Center Method (Features)
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return bstToGst(...args);
}

var bstToGst = function(root) {
  let sum = 0;
  const traverse = function(root) {
    if (root == null) {
      return;
    }
    traverse(root.right);
    sum += root.val;
    root.val = sum;
    traverse(root.left);
  }
  traverse(root);
  return root;
};
