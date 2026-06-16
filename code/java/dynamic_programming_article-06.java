public class Dynamic_programming_article_06 {
    /**
     * Dynamic programming design: longest increasing subsequence
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[] nums)");
        }

        Solution solution = new Solution();
        return solution.lengthOfLIS((int[]) args[0]);
    }

    private static class Solution {

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
