public class Algorithm_thinking_article_12 {
    /**
     * Commonly used bit operations
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] nums)");
        }

        Solution solution = new Solution();
        return solution.singleNumber((int[]) args[0]);
    }

    private static class Solution {

        public int singleNumber(int[] nums) {
            int res = 0;
            for (int n : nums) {
                res ^= n;
            }
            return res;
        }
    }
}
