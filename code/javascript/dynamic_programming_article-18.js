/**
 * Dynamic programming helped me pass "Magic Tower"
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dp(...args);
}

var calculateMinimumHP = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const memo = new Array(m).fill().map(() => new Array(n).fill(-1));
    function dp(i, j) {
        if (i === m - 1 && j === n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i === m || j === n) {
            return Number.MAX_VALUE;
        }
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        const res = Math.min(dp(i, j + 1), dp(i + 1, j)) - grid[i][j];
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
    return dp(0, 0);
};
