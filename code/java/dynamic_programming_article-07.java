public class Dynamic_programming_article_07 {
    /**
     * Dynamic programming problem-solving routine framework
     */
    public Object solve(Object... args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Expected: (int[] coins, int amount)");
        }

        Solution solution = new Solution();
        return solution.coinChange((int[]) args[0], (int) args[1]);
    }

    private static class Solution {

        int[] memo;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -666);
            return dp(coins, amount);
        }
        int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            if (memo[amount] != -666)
                return memo[amount];
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) continue;
                res = Math.min(res, subProblem + 1);
            }
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }
}
