public class Data_structures_article_02 {
    /**
     * Binary Search Tree Heart Method (Basic Operations)
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (TreeNode root, int key)");
        }

        Solution solution = new Solution();
        return solution.deleteNode((TreeNode) args[0], (int) args[1]);
    }

    private static class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                TreeNode minNode = getMin(root.right);
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
        }
        TreeNode getMin(TreeNode node) {
            while (node.left != null) node = node.left;
            return node;
        }
    }
}
