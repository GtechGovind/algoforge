public class Dynamic_programming_article_12 {
    /**
     * Optimal substructure principle and dp array traversal direction
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 5) {
            throw new IllegalArgumentException("Expected: (int m, int n, int maxMove, int startRow, int startColumn)");
        }

        Solution solution = new Solution();
        return solution.findPaths((int) args[0], (int) args[1], (int) args[2], (int) args[3], (int) args[4]);
    }

    private static class Solution {

        int[][][] memo;
        int m, n;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            this.m = m;
            this.n = n;
            memo = new int[m][n][maxMove + 1];
            for (int[][] plane : memo) {
                for (int[] row : plane) {
                    Arrays.fill(row, -1);
                }
            }
            return dp(maxMove, startRow, startColumn);
        }
        int dp(int maxMove, int i, int j) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return 1;
            }
            if (memo[i][j][maxMove] != -1) {
                return memo[i][j][maxMove];
            }
            if (maxMove == 0) {
                return 0;
            }
            long res = 0;
            res += dp(maxMove - 1, i, j + 1);
            res += dp(maxMove - 1, i + 1, j);
            res += dp(maxMove - 1, i - 1, j);
            res += dp(maxMove - 1, i, j - 1);
            memo[i][j][maxMove] = (int) (res % 1000000007);
            return memo[i][j][maxMove];
        }
    }
}
