public class Dynamic_programming_article_01 {
    /**
     * Classic dynamic programming: longest common subsequence
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (String s1, String s2)");
        }

        Solution solution = new Solution();
        return solution.longestCommonSubsequence((String) args[0], (String) args[1]);
    }

    private static class Solution {

        public int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
