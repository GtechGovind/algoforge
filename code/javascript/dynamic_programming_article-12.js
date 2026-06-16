/**
 * Optimal substructure principle and dp array traversal direction
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dp(...args);
}

var findPaths = function(m, n, maxMove, startRow, startColumn) {
    let memo = new Array(m);
    for (let i = 0; i < m; i++) {
        memo[i] = new Array(n);
        for (let j = 0; j < n; j++) {
            memo[i][j] = new Array(maxMove + 1).fill(-1);
        }
    }
    return dp(maxMove, startRow, startColumn);
    function dp(maxMove, i, j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (memo[i][j][maxMove] !== -1) {
            return memo[i][j][maxMove];
        }
        if (maxMove === 0) {
            return 0;
        }
        let res = 0;
        res += dp(maxMove - 1, i, j + 1);
        res += dp(maxMove - 1, i + 1, j);
        res += dp(maxMove - 1, i - 1, j);
        res += dp(maxMove - 1, i, j - 1);
        memo[i][j][maxMove] = res % 1000000007;
        return memo[i][j][maxMove];
    }
};
