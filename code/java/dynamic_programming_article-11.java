public class Dynamic_programming_article_11 {
    /**
     * One method to eliminate LeetCode’s robbery problem
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] nums)");
        }

        Solution solution = new Solution();
        return solution.rob((int[]) args[0]);
    }

    private static class Solution {

        private int[] memo;
        public int rob(int[] nums) {
            memo = new int[nums.length];
            Arrays.fill(memo, -1);
            return dp(nums, 0);
        }
        private int dp(int[] nums, int start) {
            if (start >= nums.length) {
                return 0;
            }
            if (memo[start] != -1) return memo[start];
            int res = Math.max(dp(nums, start + 1),
                    nums[start] + dp(nums, start + 2));
            memo[start] = res;
            return res;
        }
    }
}
