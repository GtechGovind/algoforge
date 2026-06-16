public class Data_structures_article_01 {
    /**
     * Binary Search Tree Center Method (Features)
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (TreeNode root)");
        }

        Solution solution = new Solution();
        return solution.bstToGst((TreeNode) args[0]);
    }

    private static class Solution {

        public TreeNode bstToGst(TreeNode root) {
            traverse(root);
            return root;
        }
        int sum = 0;
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
}
