public class Dynamic_programming_article_18 {
    /**
     * Dynamic programming helped me pass "Magic Tower"
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int[][] grid)");
        }

        Solution solution = new Solution();
        return solution.calculateMinimumHP((int[][]) args[0]);
    }

    private static class Solution {

        public int calculateMinimumHP(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(grid, 0, 0);
        }
        int[][] memo;
        int dp(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            if (i == m - 1 && j == n - 1) {
                return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
            }
            if (i == m || j == n) {
                return Integer.MAX_VALUE;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int res = Math.min(
                    dp(grid, i, j + 1),
                    dp(grid, i + 1, j)
            ) - grid[i][j];
            memo[i][j] = res <= 0 ? 1 : res;
            return memo[i][j];
        }
    }
}
