public class Data_structures_article_05 {
    /**
     * Core program of binary tree series algorithms
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (TreeNode root)");
        }

        Solution solution = new Solution();
        return solution.maxDepth((TreeNode) args[0]);
    }

    private static class Solution {

        int depth = 0;
        int res = 0;
        public int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }
        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            res = Math.max(res, depth);
            traverse(root.left);
            traverse(root.right);
            depth--;
        }
    }
}
