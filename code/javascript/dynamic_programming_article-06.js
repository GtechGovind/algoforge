/**
 * Dynamic programming design: longest increasing subsequence
 */
export function solve(...args) {
  // Entry point for the course exercise: pass inputs directly.
  return lengthOfLIS(...args);
}

var lengthOfLIS = function(nums) {
    let dp = new Array(nums.length).fill(1);
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
