/**
 * Binary Tree Mental Method (Construction)
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return buildTree(...args);
}

var buildTree = function(preorder, inorder) {
    var valToIndex = new Map();
    for (var i = 0; i < inorder.length; i++) {
        valToIndex.set(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
};
var build = function(preorder, preStart, preEnd,
               inorder, inStart, inEnd) {
    if (preStart > preEnd) {
        return null;
    }
    var rootVal = preorder[preStart];
    var index = valToIndex.get(rootVal);
    var leftSize = index - inStart;
    var root = new TreeNode(rootVal);
    root.left = build(preorder, preStart + 1, preStart + leftSize,
            inorder, inStart, index - 1);
    root.right = build(preorder, preStart + leftSize + 1, preEnd,
            inorder, index + 1, inEnd);
    return root;
};
