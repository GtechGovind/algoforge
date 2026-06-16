/**
 * Classic dynamic programming: throwing eggs from high-rise buildings
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return superEggDrop(...args);
}

var superEggDrop = function(K, N) {
    var dp = new Array(K + 1).fill(0).map(x => new Array(N + 1).fill(0));
    var m = 0;
    while (dp[K][m] < N) {
        m++;
        for (var k = 1; k <= K; k++)
            dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
    }
    return m;
};
