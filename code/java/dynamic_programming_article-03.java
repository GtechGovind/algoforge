public class Dynamic_programming_article_03 {
    /**
     * Classic dynamic programming: game problem
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] piles)");
        }

        Solution solution = new Solution();
        return solution.stoneGame((int[]) args[0]);
    }

    private static class Solution {

        public boolean stoneGame(int[] piles) {
            return true;
        }
    }
}
