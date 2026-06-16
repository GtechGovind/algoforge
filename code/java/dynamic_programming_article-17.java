public class Dynamic_programming_article_17 {
    /**
     * Classic dynamic programming: throwing eggs from high-rise buildings
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int K, int N)");
        }

        Solution solution = new Solution();
        return solution.superEggDrop((int) args[0], (int) args[1]);
    }

    private static class Solution {

        public int superEggDrop(int K, int N) {
            int[][] dp = new int[K + 1][N + 1];
            int m = 0;
            while (dp[K][m] < N) {
                m++;
                for (int k = 1; k <= K; k++)
                    dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
            return m;
        }
    }
}
