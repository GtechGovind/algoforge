public class Data_structures_article_07 {
    /**
     * Binary Tree Mental Method (Construction)
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[] preorder, int[] inorder)");
        }

        Solution solution = new Solution();
        return solution.buildTree((int[]) args[0], (int[]) args[1]);
    }

    private static class Solution {

        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                        inorder, 0, inorder.length - 1);
        }
        TreeNode build(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            int index = valToIndex.get(rootVal);
            int leftSize = index - inStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    inorder, index + 1, inEnd);
            return root;
        }
    }
}
