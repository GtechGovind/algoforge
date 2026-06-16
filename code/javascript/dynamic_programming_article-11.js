/**
 * One method to eliminate LeetCode’s robbery problem
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return dp(...args);
}

var rob = function(nums) {
    let memo = new Array(nums.length).fill(-1);
    return dp(nums, 0, memo);
};
function dp(nums, start, memo) {
    if (start >= nums.length) {
        return 0;
    }
    if (memo[start] != -1) return memo[start];
    let res = Math.max(dp(nums, start + 1, memo),
            nums[start] + dp(nums, start + 2, memo));
    memo[start] = res;
    return res;
}
