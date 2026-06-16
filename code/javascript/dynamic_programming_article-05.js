/**
 * Classic dynamic programming: regular expressions
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dp(...args);
}

var isMatch = function(s, p) {
    let m = s.length, n = p.length;
    let memo = new Array(m + 1);
    for (let i = 0; i < memo.length; i++) {
        memo[i] = new Array(n + 1).fill(-1);
    }
    return dp(0, 0);
    function dp(i, j) {
        if (memo[i][j] !== -1) {
            return memo[i][j];
        }
        let res = false;
        if (j === n) {
            res = i === m;
        } else {
            let firstMatch = i < m && (p[j] === s[i] || p[j] === '.');
            if (j + 1 < n && p[j + 1] === '*') {
                res = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
            } else {
                res = firstMatch && dp(i + 1, j + 1);
            }
        }
        memo[i][j] = res;
        return res;
    }
};
