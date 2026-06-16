/**
 * Classic dynamic programming: longest common subsequence
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return longestCommonSubsequence(...args);
}

var longestCommonSubsequence = function(s1, s2) {
    const m = s1.length, n = s2.length;
    const dp = new Array(m + 1).fill(0).map(() => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[m][n];
};
