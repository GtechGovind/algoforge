/**
 * Binary Search Tree Heart Method (Basic Operations)
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return deleteNode(...args);
}

var deleteNode = function(root, key) {
    if (root == null) return null;
    if (root.val == key) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        let minNode = getMin(root.right);
        root.right = deleteNode(root.right, minNode.val);
        minNode.left = root.left;
        minNode.right = root.right;
        root = minNode;
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
};
var getMin = function(node) {
    while (node.left != null) node = node.left;
    return node;
};
