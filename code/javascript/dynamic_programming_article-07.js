/**
 * Dynamic programming problem-solving routine framework
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dp(...args);
}

var coinChange = function(coins, amount) {
    let memo = new Array(amount + 1).fill(-666);
    return dp(coins, amount);
    function dp(coins, amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666)
            return memo[amount];
        let res = Number.MAX_SAFE_INTEGER;
        for (let coin of coins) {
            let subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Number.MAX_SAFE_INTEGER) ? -1 : res;
        return memo[amount];
    }
};
