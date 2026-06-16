/**
 * Classic dynamic programming: edit distance
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return min(...args);
}

var minDistance = function(s1, s2) {
    let m = s1.length, n = s2.length;
    let dp = new Array(m + 1).fill().map(() => new Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++)
        dp[i][0] = i;
    for (let j = 1; j <= n; j++)
        dp[0][j] = j;
    for (let i = 1; i <= m; i++)
        for (let j = 1; j <= n; j++)
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else
                dp[i][j] = Math.min(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1,
                    dp[i - 1][j - 1] + 1
                );
    return dp[m][n];
}
function min(a, b, c) {
    return Math.min(a, Math.min(b, c));
}
